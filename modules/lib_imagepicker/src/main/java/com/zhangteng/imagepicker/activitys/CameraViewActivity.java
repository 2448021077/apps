package com.zhangteng.imagepicker.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.yalantis.ucrop.UCrop;
import com.zhangteng.imagepicker.R;
import com.zhangteng.imagepicker.bean.ImageInfo;
import com.zhangteng.imagepicker.callback.IHandlerCallBack;
import com.zhangteng.imagepicker.config.Constant;
import com.zhangteng.imagepicker.config.ImagePickerConfig;
import com.zhangteng.imagepicker.config.ImagePickerOpen;
import com.zhangteng.imagepicker.utils.FileUtils;
import com.zhangteng.imagepicker.utils.NullUtill;
import com.zhangteng.imagepicker.utils.ScreenUtils;
import com.zhangteng.imagepicker.utils.UcropUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.annotation.Nullable;


public class CameraViewActivity extends Activity {
    private List<ImageInfo> selectImageInfo;
    private ImagePickerConfig imagePickerConfig;
    private IHandlerCallBack iHandlerCallBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_view);
        imagePickerConfig = ImagePickerOpen.getInstance().getImagePickerConfig();
        iHandlerCallBack = imagePickerConfig.getiHandlerCallBack();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ImagePickerOpen.getInstance().openCamera(CameraViewActivity.this, Constant.CAMERA_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.CAMERA_RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> paths = data.getStringArrayListExtra(Constant.CAMERA_PATH);
                String mime = data.getStringExtra(Constant.MIME);
                long height = data.getIntExtra(Constant.HEIGHT, ScreenUtils.getScreenHeight(this));
                long width = data.getIntExtra(Constant.WIDTH, ScreenUtils.getScreenWidth(this));
                List<String> selectImage = imagePickerConfig.getPathList();
                if (selectImage != null) {
                    selectImage.clear();
                    if (NullUtill.isEmpty(selectImageInfo)) {
                        selectImageInfo = new ArrayList<>();
                    }
                    for (ImageInfo info : selectImageInfo) {
                        selectImage.add(info.getPath());
                    }
                    if (!imagePickerConfig.isMultiSelect()) {
                        selectImageInfo.clear();
                        selectImage.clear();
                    }
                    selectImage.addAll(paths);
                    for (String path : paths) {
                        File imageFile = new File(path);
                        ImageInfo imageInfo = new ImageInfo();
                        imageInfo.setPath(path);
                        imageInfo.setAddTime(String.valueOf(System.currentTimeMillis() / 1000));
                        imageInfo.setMime(mime);
                        imageInfo.setWidth(width);
                        imageInfo.setHeight(height);
                        imageInfo.setName(imageFile.getName());
                        imageInfo.setFolderName(imageFile.getParentFile().getName());
                        imageInfo.setFolderPath(imageFile.getParent());
                        selectImageInfo.add(imageInfo);
                    }
                    if (imagePickerConfig.isCrop()) {
                        for (int i = selectImageInfo.size() - 1; i >= 0; i--) {
                            File sourceFile = new File(selectImageInfo.get(i).getPath());
                            String name = sourceFile.getName();
                            File parentFile = FileUtils.getCropDir(imagePickerConfig.getFilePath());
                            File destinationFile = new File(parentFile.getAbsoluteFile() + File.separator + UUID.randomUUID() + name);
                            Uri sourceUri = Uri.fromFile(sourceFile);
                            Uri destinationUri = Uri.fromFile(destinationFile);
                            UcropUtil.themeTypeCrop(CameraViewActivity.this, sourceUri, destinationUri, imagePickerConfig.getCropAspectRatio(), 1);
                        }
                    }
                }
                if (iHandlerCallBack != null)
                    iHandlerCallBack.onSuccess(selectImageInfo);
                if (!imagePickerConfig.isCrop()) {
                    Intent intent = new Intent();
                    intent.putExtra(Constant.PICKER_PATH, paths);
                    setResult(RESULT_OK, intent);
                    if (iHandlerCallBack != null) {
                        iHandlerCallBack.onFinish(selectImageInfo);
                    }
                    finish();
                }
            } else if (resultCode == Constant.CAMERA_ERROR_CODE) {
                Toast.makeText(this, "请检查相机权限", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                finish();
            }
        } else if (requestCode == UCrop.REQUEST_CROP) {
            if (resultCode == RESULT_OK) {
                updateCropSelectedImage(UCrop.getOutput(data));
            } else {
                updateCropSelectedImage(null);
            }
        }
    }

    private void updateCropSelectedImage(Uri resultUri) {
        if (NullUtill.isEmpty(selectImageInfo)) {
            selectImageInfo = new ArrayList<>();
        }
        if (resultUri != null && resultUri.getPath() != null) {
            String resultName = new File(resultUri.getPath()).getName();
            if (!NullUtill.isEmpty(resultName)) {
                for (ImageInfo imageInfo : selectImageInfo) {
                    if (!NullUtill.isEmpty(imageInfo.getName())
                            && resultName.contains(imageInfo.getName())) {
                        imageInfo.setPath(resultUri.getPath());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(resultUri.getPath(), options);
                        imageInfo.setWidth(options.outWidth);
                        imageInfo.setHeight(options.outHeight);
                    }
                }
            }
        }
        ArrayList<String> paths = new ArrayList<>();
        for (int i = selectImageInfo.size() - 1; i >= 0; i--) {
            paths.add(selectImageInfo.get(i).getPath());
        }
        Intent intent = new Intent();
        intent.putExtra(Constant.PICKER_PATH, paths);
        setResult(RESULT_OK, intent);
        if (iHandlerCallBack != null) {
            iHandlerCallBack.onFinish(selectImageInfo);
        }
        finish();
    }
}

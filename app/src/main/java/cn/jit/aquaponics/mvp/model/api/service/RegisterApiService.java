package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.HeadPostBean;
import cn.jit.aquaponics.mvp.model.entity.db.LoginBean;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RegisterApiService {
    // -----------------------------------------注册登陆相关
    @POST("auth/login")
    Observable<BaseBean<LoginBean>> requestLogin(@Query("username") String username , @Query("password") String password);

    /**
     * 用户注册
     * @param body 注册请求体
     * @return
     */
    @POST("auth/signup")
    Observable<BaseBean> requestRegister(@Body RequestBody body);



    @PUT("user/password")
    Observable<BaseBean> changePwd(@Header("Authorization") String auto,
                                       @Query("oldPassword") String oldPassword,
                                       @Query("newPassword") String newPassword);

    /**
     * 头像上传
     * @param auto
     * @param file
     * @return
     * 文件上传一定要添加 Multipart
     */
    @Multipart
    @POST("user/image")
    Observable<BaseBean<HeadPostBean>> postHeadImage(@Header("Authorization") String auto,
                                                     @Part MultipartBody.Part file);

}

package cn.jit.aquaponics.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import cn.jit.aquaponics.mvp.model.api.ExceptionHandle;
import cn.jit.aquaponics.utils.RxCrashUtils;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * Created by goldze on 2017/6/15.
 */

public class BaseApplication extends MultiDexApplication {
    private static BaseApplication sInstance;

    public static BaseApplication getsInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        RxCrashUtils.getInstance(this).init();
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                ExceptionHandle.ResponeThrowable responeThrowable = ExceptionHandle.handleException(throwable);
                Log.e("error is", responeThrowable.message);
                throwable.printStackTrace();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}

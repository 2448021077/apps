package cn.jit.aquaponics;

import cn.jit.aquaponics.base.BaseApplication;
import cn.jit.aquaponics.di.component.AppComponent;
import cn.jit.aquaponics.di.component.DaggerAppComponent;
import cn.jit.aquaponics.di.module.AppModule;
import cn.jit.aquaponics.di.module.AquApiModule;

public class MyApplication extends BaseApplication {

    private static MyApplication myApplication;

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    private AppComponent appComponent;

    private void initComponent() {
        appComponent = DaggerAppComponent.builder()
                .aquApiModule(new AquApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static String USER_TOKEN = "";
}

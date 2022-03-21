package cn.jit.aquaponics.mvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.jit.aquaponics.R;
import cn.jit.aquaponics.base.BaseActivity;
import cn.jit.aquaponics.di.component.AppComponent;
import cn.jit.aquaponics.di.component.DaggerLoginComponent;
import cn.jit.aquaponics.mvp.contract.LoginContract;
import cn.jit.aquaponics.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @Override
    protected void initBaseData() {

    }

    @Override
    protected void baseConfigView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void loginSuccess(String s) {

    }

    @Override
    public void loginFailed() {

    }
}
package cn.jit.aquaponics.mvp.contract;

import cn.jit.aquaponics.base.BaseContract;


public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(String s);

        void loginFailed();
    }

    interface Presenter extends BaseContract.BasePresenter<LoginContract.View> {
        void loginWith(String usr, String pwd);
    }
}

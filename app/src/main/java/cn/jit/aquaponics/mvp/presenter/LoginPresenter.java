package cn.jit.aquaponics.mvp.presenter;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;

import cn.jit.aquaponics.base.RxPresenter;
import cn.jit.aquaponics.mvp.contract.LoginContract;
import cn.jit.aquaponics.mvp.model.api.ProjectApi;
import cn.jit.aquaponics.utils.RxThreadUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private ProjectApi projectApi, projectStringApi;
    private Context context;

    @Inject
    public LoginPresenter(Context context, @Named("api-0") ProjectApi projectApi, @Named("api-stringconver") ProjectApi projectApi3) {
        this.context = context;
        this.projectApi = projectApi;
        this.projectStringApi = projectApi3;
    }

    @Override
    public void loginWith(String usr, String pwd) {
        Disposable disposable = projectStringApi.login(usr, pwd)
                .doOnSuccess(new Consumer<String>() {

                    @Override
                    public void accept(String list) throws Exception {

                    }
                })
                .compose(RxThreadUtil::toSimpleSingle)
                .subscribe(response -> {
                            mView.loginSuccess(response);
                        },
                        e -> {
                            mView.loginFailed();
                            e.printStackTrace();
                        });
        addDisposable(disposable);
    }
}

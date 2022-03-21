package cn.jit.aquaponics.di.component;

import cn.jit.aquaponics.mvp.ui.LoginActivity;
import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface LoginComponent {

    LoginActivity inject(LoginActivity loginActivity);
}

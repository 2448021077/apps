package cn.jit.aquaponics.mvp.model.api.service;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginApiService {

    //书架有效阅读时间
    @POST("/user/login")
    Single<String> login(@Field("username") String username,
                         @Field("password") String password);

    //书架有效阅读时间
    @POST("user/register")
    Single<String> register();
}

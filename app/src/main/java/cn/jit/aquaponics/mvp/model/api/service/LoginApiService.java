package cn.jit.aquaponics.mvp.model.api.service;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface LoginApiService {

    //
    @Multipart
    @POST("/user/login")
    Single<String> login(@Part ("username") RequestBody username,
                        @Part ("password") RequestBody password);

    //书架有效阅读时间
    @POST("user/register")
    Single<String> register();
}

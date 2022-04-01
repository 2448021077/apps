package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TimeApiService {
    // 控制 时间 开关
    @POST("micro-iot/envctldef/updateTmCtl")
    Observable<BaseBean<Boolean>> ctrlAutoTime(@Header("Authorization") String auto,
                                               @Query("id") int id,
                                               @Query("env_type") String env_type,
                                               @Query("time") String time,
                                               @Query("opt") int opt,
                                               @Query("autofg") int ison_fg);


}

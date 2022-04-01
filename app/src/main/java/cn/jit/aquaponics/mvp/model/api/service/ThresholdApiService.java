package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.AutoStatusBean;
import cn.jit.aquaponics.mvp.model.entity.db.AutoTimeStatusBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ThresholdApiService {
    // 获取  阈值控制 状态
    @GET("micro-iot/envctldef/lstThCtlParam")
    Observable<BaseBean<List<AutoStatusBean>>> getAutoEquipsStatus(@Header("Authorization") String auto,
                                                                   @Query("cell_id") int cellId);

    // 控制 阈值 开关
    @POST("micro-iot/envctldef/updateThCtl")
    Observable<BaseBean<Boolean>>  ctrlAuto(@Header("Authorization") String auto,
                                            @Query("id") int id,
                                            @Query("env_type") String env_type,
                                            @Query("param_id") int param_id,
                                            @Query("wnup") float wnup,
                                            @Query("wndw") float wndw,
                                            @Query("actup") float actup,
                                            @Query("actdw") float actdw,
                                            @Query("autofg") int ison_fg);

    // 获取  阈值控制 状态
    @GET("micro-iot/envctldef/lstTmCtlParam")
    Observable<BaseBean<List<AutoTimeStatusBean>>> getAutoTimeStatus(@Header("Authorization") String auto,
                                                                     @Query("cell_id") int cellId);

}

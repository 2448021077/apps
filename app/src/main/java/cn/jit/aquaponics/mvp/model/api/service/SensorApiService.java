package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.SensorBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SensorApiService {
    // 获取 终端传感器
    @GET("micro-iot/sensordef/termSensors")
    Observable<BaseBean<List<SensorBean>>> getAllSensors(@Header("Authorization") String auto,
                                                         @Query("term_id") int termid);

    // 增加传感器
    @POST("micro-iot/sensordef/addSensor")
    Observable<BaseBean<SensorBean>>  addSensor(@Header("Authorization") String auto,
                                                        @Query("cell_id") int cell_id,
                                                        @Query("term_id") int term_id,
                                                        @Query("addr") int addr,
                                                        @Query("product") String sensor_type,
                                                        @Query("sensor_name") String sensor_name);

    // 获取 自定义传感器类型
    @GET("micro-iot/sensordef/listProduct")
    Observable<BaseBean<String[]>> getDefSensorType(@Header("Authorization") String auto,
                                                        @Query("ttid") int termtype);

    // 删除 传感器
    @DELETE("micro-iot/sensordef/deleteSensor")
    Observable<BaseBean> deleteSensor(@Header("Authorization") String auto,@Query("sid") String sid);

    // 修改传感器
    @POST("micro-iot/sensordef/updateSensor")
    Observable<BaseBean> updateSensor(@Header("Authorization") String auto,
                                          @Query("id") int id,
                                          @Query("cell_id") int cell_id,
                                          @Query("addr") int addr,
                                          @Query("sensor_name") String sensor_name);

}

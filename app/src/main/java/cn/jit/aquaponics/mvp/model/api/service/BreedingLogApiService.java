package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.AutoLogBean;
import cn.jit.aquaponics.mvp.model.entity.db.CultureLogBean;
import cn.jit.aquaponics.mvp.model.entity.db.WarnLogBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BreedingLogApiService {
    // -----------------------------------------种养日志相关

    /**
     * 插入水质信息
     * @param auto
     * @param pound_id
     * @param date
     * @param weather
     * @param medicine
     * @param remark
     * @param temperature
     * @param o2
     * @param ph
     * @return
     */
    @POST("water/insert")
    Observable<BaseBean> insertWater(@Header("Authorization") String auto,
                                     @Query("pound_id") int pound_id,
                                     @Query("date") String date,
                                     @Query("weather") String weather,
                                     @Query("medicine") String medicine,
                                     @Query("remark") String remark,
                                     @Query("temperature") String temperature,
                                     @Query("o2") String o2,
                                     @Query("ph") String ph);

    /**
     * 插入投喂信息
     * @param auto
     * @param pound_id
     * @param date
     * @param count1
     * @param count2
     * @param count3
     * @param count4
     * @param count5
     * @param count6
     * @return
     */
    @POST("feed/insert")
    Observable<BaseBean> insertFeed(@Header("Authorization") String auto,
                                        @Query("pound_id") int pound_id,
                                        @Query("date") String date,
                                        @Query("count1") long count1,
                                        @Query("count2") long count2,
                                        @Query("count3") long count3,
                                        @Query("count4") long count4,
                                        @Query("count5") long count5,
                                        @Query("count6") long count6
    );

    /**
     * 获取特定生产单元对应时间段的历史日志
     * @param auto
     * @param pound_id
     * @param start_date
     * @param end_date
     * @return
     */
    @GET("water/diary")
    Observable<BaseListBean<CultureLogBean>> queryDiaryLogInfo(@Header("Authorization") String auto,
                                                               @Query("pound_id") int pound_id,
                                                               @Query("start_date") String start_date,
                                                               @Query("end_date") String end_date);
    // 获取  自动控制 日志
    @GET("micro-iot/opt/autoActLogQuery")
    Observable<BaseBean<List<AutoLogBean>>> getAutoLog(@Header("Authorization") String auto,
                                                       @Query("cell_id") int cellId,
                                                       @Query("start_time") String start_time,
                                                       @Query("end_time") String end_time);

    // 获取  预警 日志
    @GET("micro-iot/opt/warnLogQuery")
    Observable<BaseBean<List<WarnLogBean>>> getWarnLog(@Header("Authorization") String auto,
                                                       @Query("cell_id") int cellId,
                                                       @Query("start_time") String start_time,
                                                       @Query("end_time") String end_time);


}

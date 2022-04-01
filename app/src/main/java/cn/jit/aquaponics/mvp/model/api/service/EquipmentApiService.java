package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.EquipBean;
import cn.jit.aquaponics.mvp.model.entity.db.EquipStatusBean;
import cn.jit.aquaponics.mvp.model.entity.db.EquipTypeBean;
import cn.jit.aquaponics.mvp.model.entity.db.HisBean;
import cn.jit.aquaponics.mvp.model.entity.db.OrgBean;
import cn.jit.aquaponics.mvp.model.entity.db.RealBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EquipmentApiService {
    // 获取 设备类型
    @GET("micro-iot/equipdef/showEquipType")
    Observable<BaseBean<List<EquipTypeBean>>> getEquipType(@Header("Authorization") String auto);


    // 获取 终端设备
    @GET("micro-iot/equipdef/listTermEquip")
    Observable<BaseBean<List<EquipBean>>> getAllEquips(@Header("Authorization") String auto,
                                                       @Query("term_id") int termid);

    // 删除 设备
    @DELETE("micro-iot/equipdef/delEquip")
    Observable<BaseBean> deleteEquip(@Header("Authorization") String auto, @Query("id") String id);

    // 修改设备
    @POST("micro-iot/equipdef/updateEquip")
    Observable<BaseBean> updateEquip(@Header("Authorization") String auto,
                                         @Query("id") int id,
                                         @Query("cell_id") int cell_id,
                                         @Query("term_id") int term_id,
                                         @Query("addr") int addr,
                                         @Query("road") int road,
                                         @Query("equip_name") String equip_name);

    // 修改设备
    @POST("micro-iot/celldef/updateCell")
    Observable<BaseBean> updateCell(@Header("Authorization") String auto,
                                        @Query("id") int id,
                                        @Query("length") double length,
                                        @Query("width") double width,
                                        @Query("longitude") double longitude,
                                        @Query("latitude") double latitude,
                                        @Query("cell_type") String product,
                                        @Query("agri_prod") String prod,
                                        @Query("cell_name") String cell_name,
                                        @Query("user_name") String user_name);

    // 获取  生产单元 设备
    @GET("micro-iot/equipdef/listEquips")
    Observable<BaseBean<List<EquipBean>>> getCellEquips(@Header("Authorization") String auto,
                                                                @Query("cell_id") int cellId);

    // 获取  生产单元 设备
    @GET("micro-iot/opt/equQuery")
    Observable<BaseBean<List<EquipStatusBean>>> getCellEquipsStatus(@Header("Authorization") String auto,
                                                                    @Query("cell_id") int cellId);
    // 获取  生产单元 原始数据
    @GET("micro-iot/sensordef/cellParams")
    Observable<BaseBean<List<OrgBean>>> getOrgData(@Header("Authorization") String auto,
                                                   @Query("all_env") boolean all_env,
                                                   @Query("cell_id") int cellId);


    // 获取  生产单元 实时数据
    @GET("micro-iot/opt/rtQuery")
    Observable<BaseBean<List<RealBean>>> getRealData(@Header("Authorization") String auto,
                                                     @Query("all_env") boolean all_env,
                                                     @Query("cell_id") int cellId);

    // 获取  生产单元 历史数据
    @GET("micro-iot/opt/hisQuery")
    Observable<BaseBean<List<HisBean>>> getHisData(@Header("Authorization") String auto,
                                                   @Query("all_env") boolean all_env,
                                                   @Query("cell_id") int cellId,
                                                   @Query("start_time") String start_time,
                                                   @Query("end_time") String end_time);

}

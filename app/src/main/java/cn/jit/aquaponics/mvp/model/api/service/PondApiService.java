package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseFishPondPageBean;
import cn.jit.aquaponics.mvp.model.entity.db.FishPondBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PondApiService {
    // 增加 塘口
    @POST("micro-aquaculture/pond/add")
    Observable<BaseBean> addFishPond(@Header("Authorization") String auto,
                                     @Query("name") String pond_name,
                                     @Query("length") double length,
                                     @Query("width") double width,
                                     @Query("depth") double depth,
                                     @Query("orientation") String orientation,
                                     @Query("longitude") double longitude,
                                     @Query("latitude") double latitude,
                                     @Query("address") String address,
                                     @Query("product") String product,
                                     @Query("username") String username);

    // 查询 塘口 分页
    @GET("micro-aquaculture/pond/queri")
    Observable<BaseBean<BaseFishPondPageBean<FishPondBean>>> getUserPonds(@Header("Authorization") String auto,
                                                                          @Query("username") String username,
                                                                          @Query("pageNum") int pageNum,
                                                                          @Query("pageSize") int pageSize);

    // 查询 塘口 全部
    @GET("micro-aquaculture/pond/queriAll")
    Observable<BaseBean<List<FishPondBean>>> getAllUserPonds(@Header("Authorization") String auto,
                                                                     @Query("username") String username);

    // 删除 塘口
    @DELETE("micro-aquaculture/pond/delete/{id}")
    Observable<BaseBean> deleteFishPond(@Header("Authorization") String auto, @Query("id") int id);

    // 更新 塘口
    @PUT("micro-aquaculture/pond/update/{id}")
    Observable<BaseBean> updateFishPond(@Header("Authorization") String auto,
                                            @Path("id") int id,
                                            @Query("name") String pond_name,
                                            @Query("length") double length,
                                            @Query("width") double width,
                                            @Query("depth") double depth,
                                            @Query("orientation") String orientation,
                                            @Query("longitude") double longitude,
                                            @Query("latitude") double latitude,
                                            @Query("address") String address,
                                            @Query("product") String product,
                                            @Query("username") String username);

}

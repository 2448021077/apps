package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseFeedingTemplatePageBean;
import cn.jit.aquaponics.mvp.model.entity.db.FeedingTemplateBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ModelApiService {
    // 增加 模板
    @POST("micro-aquaculture/feedtemplate/add")
    Observable<BaseBean> addFeedingTemplate(@Header("Authorization") String auto,
                                            @Query("name") String name,
                                            @Query("batchNumber") String batchNumber,
                                            @Query("pond") String pond,
                                            @Query("food") String food,
                                            @Query("amount") double amount,
                                            @Query("unit") String unit,
                                            @Query("time") String time,
                                            @Query("remarks") String remarks,
                                            @Query("username") String username);

    // 修改 模板
    @PUT("micro-aquaculture/feedtemplate/update/{id}")
    Observable<BaseBean> updateFeedingTemplate(@Header("Authorization") String auto,
                                                   @Path("id") int id,
                                                   @Query("name") String name,
                                                   @Query("batchNumber") String batchNumber,
                                                   @Query("pond") String pond,
                                                   @Query("food") String food,
                                                   @Query("amount") double amount,
                                                   @Query("unit") String unit,
                                                   @Query("time") String time,
                                                   @Query("remarks") String remarks,
                                                   @Query("username") String username);

    // 删除 模板
    @DELETE("micro-aquaculture/feedtemplate/delete/{id}")
    Observable<BaseBean> deleteFeedingTemplate(@Header("Authorization") String auto,
                                                   @Path("id") int id);

    // 查询 模板 分页
    @GET("micro-aquaculture/feedtemplate/queri")
    Observable<BaseBean<BaseFeedingTemplatePageBean<FeedingTemplateBean>>> getUserTemplate(@Header("Authorization") String auto,
                                                                                           @Query("username") String username,
                                                                                           @Query("pageNum") int pageNum,
                                                                                           @Query("pageSize") int pageSize);

    // 查询 模板 全部
    @GET("micro-aquaculture/feedtemplate/queriAll")
    Observable<BaseBean<List<FeedingTemplateBean>>> getAllUserTemplate(@Header("Authorization") String auto,
                                                                               @Query("username") String username);

}

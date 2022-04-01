package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseFeedingFoodPageBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseFishInputPageBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseInputPageBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaseReagentInputPageBean;
import cn.jit.aquaponics.mvp.model.entity.db.FeedingFoodBean;
import cn.jit.aquaponics.mvp.model.entity.db.FishInputBean;
import cn.jit.aquaponics.mvp.model.entity.db.InputBean;
import cn.jit.aquaponics.mvp.model.entity.db.ReagentInputBean;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InputTypeApiService {
    // 获取固定投入类型
    @GET("ac-service/type/fixed")
    Observable<BaseBean<String[]>> getGudingType();

    // 获取固定投入类型
    @GET("ac-service/type/observe/name")
    Observable<BaseBean<String[]>> getObserveType();

    // 增加 饲料投入
    @POST("micro-aquaculture/dailyfeeding/add")
    Observable<BaseBean> addFeedingFood(@Header("Authorization") String auto,
                                            @Query("name") String templateName,
                                            @Query("batchNumber") String batchNumber,
                                            @Query("pond") String pond,
                                            @Query("food") String food,
                                            @Query("amount") double amount,
                                            @Query("unit") String unit,
                                            @Query("time") String time,
                                            @Query("remarks") String remarks,
                                            @Query("username") String username);

    // 修改 饲料投入
    @PUT("micro-aquaculture/dailyfeeding/update/{id}")
    Observable<BaseBean> updateFeedingFood(@Header("Authorization") String auto,
                                               @Path("id") int id,
                                               @Query("name") String templateName,
                                               @Query("batchNumber") String batchNumber,
                                               @Query("pond") String pond,
                                               @Query("food") String food,
                                               @Query("amount") double amount,
                                               @Query("unit") String unit,
                                               @Query("time") String time,
                                               @Query("remarks") String remarks,
                                               @Query("username") String username);

    // 查询 饲料投入 分页
    @GET("micro-aquaculture/dailyfeeding/queri")
    Observable<BaseBean<BaseFeedingFoodPageBean<FeedingFoodBean>>> getUserFeedingFood(@Header("Authorization") String auto,
                                                                                      @Query("username") String username,
                                                                                      @Query("pageNum") int pageNum,
                                                                                      @Query("pageSize") int pageSize);

    // 查询 饲料投入 全部
    @GET("micro-aquaculture/dailyfeeding/queriall")
    Observable<BaseBean<List<FeedingFoodBean>>> getAllUserFeedingFood(@Header("Authorization") String auto,
                                                                              @Query("username") String username);

    // 删除 饲料投入
    @DELETE("micro-aquaculture/dailyfeeding/delete/{id}")
    Observable<BaseBean> deleteFeedingFood(@Header("Authorization") String auto,
                                               @Path("id") int id);

    // 增加 调水剂投入
    @POST("micro-aquaculture/reagent/add")
    Observable<BaseBean> addReagentInput(@Header("Authorization") String auto,
                                             @Query("batchNumber") String batchNumber,
                                             @Query("pond") String pond,
                                             @Query("reagent") String reagent,
                                             @Query("amount") double amount,
                                             @Query("unit") String unit,
                                             @Query("time") String time,
                                             @Query("remarks") String remarks,
                                             @Query("username") String username);

    // 查找 调水剂投入 分页
    @GET("micro-aquaculture/reagent/queri")
    Observable<BaseBean<BaseReagentInputPageBean<ReagentInputBean>>> getUserReagentInput(@Header("Authorization") String auto,
                                                                                         @Query("username") String username,
                                                                                         @Query("pageNum") int pageNum,
                                                                                         @Query("pageSize") int pageSize);

    // 查找 调水剂投入 全部
    @GET("micro-aquaculture/reagent/queriAll")
    Observable<BaseBean<List<ReagentInputBean>>> getAllUserReagentInput(@Header("Authorization") String auto,
                                                                                @Query("username") String username);

    // 更新 调水剂投入
    @PUT("micro-aquaculture/reagent/update/{id}")
    Observable<BaseBean> updateReagentInput(@Header("Authorization") String auto,
                                                @Path("id") int id,
                                                @Query("batchNumber") String batchNumber,
                                                @Query("pond") String pond,
                                                @Query("reagent") String reagent,
                                                @Query("amount") double amount,
                                                @Query("unit") String unit,
                                                @Query("time") String time,
                                                @Query("remarks") String remarks,
                                                @Query("username") String username);

    // 删除 调水剂投入
    @DELETE("micro-aquaculture/reagent/delete/{id}")
    Observable<BaseBean> deleteReagentInput(@Header("Authorization") String auto,
                                                @Path("id") int id);



    // 增加 鱼苗投入
    @POST("micro-aquaculture/fishinput/add")
    Observable<BaseBean> addFishInput(@Header("Authorization") String auto,
                                          @Query("type") String fishType,
                                          @Query("amount") double amount,
                                          @Query("unit") String unit,
                                          @Query("date") String date,
                                          @Query("pond") List<String> pond,
                                          @Query("batchNumber") String batchNumber,
                                          @Query("username") String username);

    // 删除 鱼苗投入
    @DELETE("micro-aquaculture/fishinput/delete/{id}")
    Observable<BaseBean> deleteFishInput(@Header("Authorization") String auto,
                                             @Query("id") int id);

    // 更新 鱼苗投入
    @PUT("micro-aquaculture/fishinput/update/{id}")
    Observable<BaseBean> updateFishInput(@Header("Authorization") String auto,
                                             @Path("id") int id,
                                             @Query("type") String fishType,
                                             @Query("amount") double amount,
                                             @Query("unit") String unit,
                                             @Query("date") String date,
                                             @Query("pond") List<String> pond,
                                             @Query("batchNumber") String batchNumber,
                                             @Query("username") String username);

    // 查询 鱼苗投入 分页
    @GET("micro-aquaculture/fishinput/queri")
    Observable<BaseBean<BaseFishInputPageBean<FishInputBean>>> getUserFishInput(@Header("Authorization") String auto,
                                                                                @Query("username") String username,
                                                                                @Query("pageNum") int pageNum,
                                                                                @Query("pageSize") int pageSize);

    //查询 鱼苗投入 全部
    @GET("micro-aquaculture/fishinput/queriAll")
    Observable<BaseBean<List<FishInputBean>>> getAllUserFishInput(@Header("Authorization") String auto,
                                                                          @Query("username") String username);
    // 增加 投入品
    @Multipart
    @POST("micro-aquaculture/inputs/add")
    Observable<BaseBean> addInput(@Header("Authorization") String auto,
                                      @Query("type") String inputType,
                                      @Query("name") String inputName,
                                      @Query("manufacture") String manufacturer,
                                      @Part List<MultipartBody.Part> pictures,
                                      @Query("remarks") String remarks,
                                      @Query("username") String username);

    // 查找 投入品 分页
    @GET("micro-aquaculture/inputs/queri")
    Observable<BaseBean<BaseInputPageBean<InputBean>>> getUserInputs(@Header("Authorization") String auto,
                                                                     @Query("username") String username,
                                                                     @Query("pageNum") int pageNum,
                                                                     @Query("pageSize") int pageSize);

    // 查找 投入品 全部
    @GET("micro-aquaculture/inputs/queriAll")
    Observable<BaseBean<List<InputBean>>> getAllUserInputs(@Header("Authorization") String auto,
                                                                   @Query("username") String username);

    // 删除 投入品
    @DELETE("micro-aquaculture/inputs/delete/{id}")
    Observable<BaseBean> deleteInput(@Header("Authorization") String auto,
                                         @Query("id") int id);

    // 更新 投入品
    @Multipart
    @PUT("micro-aquaculture/inputs/update/{id}")
    Observable<BaseBean> updateInput(@Header("Authorization") String auto,
                                         @Path("id") int id,
                                         @Query("type") String inputType,
                                         @Query("name") String inputName,
                                         @Query("manufacture") String manufacturer,
                                         @Part List<MultipartBody.Part> pictures,
                                         @Query("remarks") String remarks,
                                         @Query("username") String username);

}

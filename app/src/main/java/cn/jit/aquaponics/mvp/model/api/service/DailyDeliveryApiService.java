package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.DailyThrowBean;
import cn.jit.aquaponics.mvp.model.entity.db.TemplateBean;
import cn.jit.aquaponics.mvp.model.entity.db.TypeTemplateBean;
import cn.jit.aquaponics.mvp.model.entity.db.TypeThrowBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DailyDeliveryApiService {
    // 获取所有日常投放数据
    @GET("ac-service/throw/")
    Observable<BaseBean<TypeThrowBean>> getThrow(@Header("Authorization") String auto,
                                                 @Query("pageNum") int pageNum);


    // 增加日常投放
    @POST("ac-service/throw/add")
    Observable<BaseBean<DailyThrowBean>>  addThrow(@Header("Authorization") String auto,
                                                   @Body DailyThrowBean dailyThrowBean);

    // 删除日常投放
    @DELETE("ac-service/throw/{ids}")
    Observable<BaseBean> deleteThrow(@Header("Authorization") String auto, @Path("ids") String ids);


    // 修改日常投放
    @PUT("ac-service/throw/{id}")
    Observable<BaseBean<DailyThrowBean>> updateThrow(@Header("Authorization") String auto,
                                                             @Body DailyThrowBean dailyThrowBean,
                                                             @Path("id") int Id);


    // 增加日常投放模板
    @POST("ac-service/template/add")
    Observable<BaseBean<TemplateBean>>  addTemplate(@Header("Authorization") String auto,
                                                    @Body TemplateBean templateBean);

    // 删除日常投放模板
    @DELETE("ac-service/template/{ids}")
    Observable<BaseBean> deleteTemplate(@Header("Authorization") String auto,@Path("ids") String ids);

    // 修改日常投放模板
    @PUT("ac-service/template/update")
    Observable<BaseBean<TemplateBean>> updateTemplate(@Header("Authorization") String auto,
                                                              @Body TemplateBean templateBean);

    // 获取所有日常投放模板数据
    @GET("ac-service/template/all/")
    Observable<BaseBean<TypeTemplateBean>> getTemplate(@Header("Authorization") String auto,
                                                       @Query("pageNum") int pageNum);
    // 获取所有日常投放数据
    @GET("ac-service/throw/expert")
    Observable<BaseBean<TypeThrowBean>> getThrowByUser(@Header("Authorization") String auto,
                                                               @Query("pageNum") int pageNum,
                                                               @Query("username") String username);

}

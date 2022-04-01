package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.RizhiBean;
import cn.jit.aquaponics.mvp.model.entity.db.TypeRizhiBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ObservationRecordApiService {
    // 增加观察记录
    @POST("ac-service/observe/add")
    Observable<BaseBean<RizhiBean>> addRizhi(@Header("Authorization") String auto,
                                             @Query("name") String name,
                                             @Query("remark") String content,
                                             @Query("time") String tme,
                                             @Query("pound_id") int pondId);

    // 删除观察记录
    @DELETE("ac-service/observe/{ids}")
    Observable<BaseBean> deleteRizhi(@Header("Authorization") String auto,@Path("ids") String ids);


    // 修改观察记录
    @PUT("ac-service/observe/update")
    Observable<BaseBean<RizhiBean>> updateRizhi(@Header("Authorization") String auto,
                                                        @Query("name") String name,
                                                        @Query("content") String content,
                                                        @Query("pound_id") int pondId,
                                                        @Query("id") int Id);

    // 查询观察记录
    @GET("ac-service/observe/")
    Observable<BaseBean<TypeRizhiBean>> getRizhi(@Header("Authorization") String auto,
                                                 @Query("pageNum") int pageNum);

}

package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.DownLogBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LogManagementApiService {
    /* 日志记录的管理 ======================*/
    @POST("downlog/add")
    Observable<BaseBean> addDownloadLog(@Header("Authorization") String auto, @Query("downlogname") String downlogname);

    @DELETE("downlog/{ids}")
    Observable<BaseBean> deleteSmLogs(@Header("Authorization") String auto,@Path("ids") String ids);

    @GET("downlog/all")
    Observable<BaseListBean<DownLogBean>> getaAllLogs(@Header("Authorization") String auto);

}

package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.ManuInfoBean;
import cn.jit.aquaponics.mvp.model.entity.db.TermBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TerminalApiService {
    // 增加终端
    @POST("micro-iot/termdef/addTerm")
    Observable<BaseBean<TermBean>> addTerm(@Header("Authorization") String auto,
                                           @Query("type") int type,
                                           @Query("deveui") String deveui,
                                           @Query("manu") String manu,
                                           @Query("product") String prod,
                                           @Query("name") String name,
                                           @Query("user") String user);

    // 修改终端
    @POST("micro-iot/termdef/updateTerm")
    Observable<BaseBean> updateTerm(@Header("Authorization") String auto,
                                        @Query("id") int id,
                                        @Query("deveui") String deveui,
                                        @Query("name") String name,
                                        @Query("user") String user);
    // 删除终端
    @DELETE("micro-iot/termdef/deleteSensor")
    Observable<BaseBean> deleteTerm(@Header("Authorization") String auto,@Query("id") String id);

    // 1 查询终端类型 终端厂商 产品
    @GET("micro-iot/termdef/listTermManus")
    Observable<BaseBean<List<ManuInfoBean>>> getAllManus(@Header("Authorization") String auto);

}

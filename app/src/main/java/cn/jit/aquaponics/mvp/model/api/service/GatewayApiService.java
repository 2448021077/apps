package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.TypeTermBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GatewayApiService {
    // 获取所有网关
    @GET("micro-iot/termdef/listAllTerms")
    Observable<BaseBean<TypeTermBean>> getAllTerms(@Header("Authorization") String auto,
                                                   @Query("pageNum") int pageNum);


}

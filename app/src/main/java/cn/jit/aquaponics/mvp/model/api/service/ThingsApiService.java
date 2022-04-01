package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ThingsApiService {
    // 获取 药品
    @GET("ac-service/type/medicine")
    Observable<BaseBean<String[]>> getMedicineType();

    // 获取购买物品
    @GET("ac-service/type/cost")
    Observable<BaseBean<String[]>> getGoumaiType();

    // 获取销售物品
    @GET("ac-service/type/sale")
    Observable<BaseBean<String[]>> getXiaoshouType();

    // 获取饵料名称
    @GET("ac-service/type/feed")
    Observable<BaseBean<String[]>> getErliaoType();

}

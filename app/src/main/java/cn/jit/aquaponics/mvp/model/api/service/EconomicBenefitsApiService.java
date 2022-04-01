package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.IncomeBean;
import cn.jit.aquaponics.mvp.model.entity.db.TypeIncomeBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EconomicBenefitsApiService {
    // 增加经济效益
    @POST("ac-service/income/add")
    Observable<BaseBean<IncomeBean>>  addIncome(@Header("Authorization") String auto,
                                                @Body IncomeBean incomeBean);

    // 根据类型获取经济效益
    @GET("ac-service/income/{type}")
    Observable<BaseBean<TypeIncomeBean>> getIncome(@Header("Authorization") String auto,
                                                   @Path("type") int type,
                                                   @Query("pageNum") int pageNum
    );

    // 删除经济效益
    @DELETE("ac-service/income/{ids}")
    Observable<BaseBean> deleteIncome(@Header("Authorization") String auto,@Path("ids") String ids);

    // 修改经济效益
    @PUT("ac-service/income/update")
    Observable<BaseBean<IncomeBean>> updateIncome(@Header("Authorization") String auto,@Body IncomeBean incomeBean);


}

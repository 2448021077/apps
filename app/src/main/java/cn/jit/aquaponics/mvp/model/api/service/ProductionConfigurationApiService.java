package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.PondMainBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductionConfigurationApiService {
    // -----------------------------------------生产单元配置相关
    /**查询该用户下的所有生产单元信息
     * @param auto
     * @return
             */
    @GET("pound/")
    Observable<BaseListBean<PondMainBean>> queryPondMainInfo(@Header("Authorization") String auto);

    /**
     * 添加生产单元
     * @param auto
     * @param body
     * @return
     */
    @POST("pound/add")
    Observable<BaseBean<PondMainBean>> requestAddPond(@Header("Authorization") String auto, @Body RequestBody body);

    /**
     * 删除对应的生产单元
     * @param auto
     * @param pondID
     * @return
     */
    @DELETE("pound/{id}")
    Observable<BaseBean> requestDelPond(@Header("Authorization") String auto,@Path("id") int pondID);

    /**
     * 更新对应生产单元的信息
     * @param auto
     * @param pondID
     * @param body
     * @return
     */
    @PUT("pound/{id}")
    Observable<BaseBean<PondMainBean>> requestUpdatePond(@Header("Authorization") String auto,@Path("id") int pondID,@Body RequestBody body);

}

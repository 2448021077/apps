package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.ConfigMainBean;
import cn.jit.aquaponics.mvp.model.entity.db.CtrlBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;
import cn.jit.aquaponics.mvp.model.entity.db.ZhishiBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RobertDispositionApiService {
    /**
     * 获得当前用户下的配置信息
     * @param auto
     * @return
     */
    @GET("settings/user")
    Observable<BaseListBean<ConfigMainBean>> queryAllConfig(@Header("Authorization") String auto);

    /**
     * 增加设备配置信息
     * @param auto
     * @param body
     * @return
     */
    @POST("settings/add")
    Observable<BaseBean<ConfigMainBean>> requestAddConfig(@Header("Authorization") String auto, @Body RequestBody body);

    /**
     * 更新设备配置信息
     * @param auto
     * @param configID
     * @param body
     * @return
     */
    @PUT("settings/{id}")
    Observable<BaseBean<ConfigMainBean>> requestUpdateConfig(@Header("Authorization") String auto, @Path("id") int configID, @Body RequestBody body);

    /**
     * 删除设备信息
     * @param auto
     * @param configID
     * @return
     */
    @DELETE("settings/{id}")
    Observable<BaseBean> requestDelConfig(@Header("Authorization") String auto,@Path("id") int configID);

    // 控制 设备
    @POST("micro-iot/opt/control")
    Observable<BaseBean<CtrlBean>>  ctrlEquip(@Header("Authorization") String auto,
                                              @Query("appusrid") int appusrid,
                                              @Query("equip_id") int equip_id,
                                              @Query("ison_fg") int ison_fg);

    @GET("ac-service/aquacu/all")
    Observable<BaseBean<PageBean<ZhishiBean>>> queryZhishi(@Query("pageNum") int pageNum);

    @GET("ac-service/aquacu/{id}")
    Observable<BaseBean<ZhishiBean>> queryDetailZhishiInfo(@Path("id") int id);



}

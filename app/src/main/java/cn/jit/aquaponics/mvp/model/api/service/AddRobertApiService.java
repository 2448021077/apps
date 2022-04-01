package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.RobotMainBean;
import cn.jit.aquaponics.mvp.model.entity.db.RobotPageBean;
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

public interface AddRobertApiService {
    // -----------------------------------------机器人添加相关
    /**
     * 客户端增加机器人
     * @param auto
     * @param body
     * @return
     */
    @POST("robert/add")
    Observable<BaseBean<RobotMainBean>> requestAddRobot(@Header("Authorization") String auto, @Body RequestBody body);

    /**
     * 查询对应客户下的所有机器人
     * @param auto
     * @param userID
     * @return
     */
    @GET("robert/customer")
    Observable<BaseListBean<RobotMainBean>> queryMyRobot(@Header("Authorization") String auto, @Query("customer_id") int userID);

    /**
     * 查询对应客户下的所有机器人
     * @param auto
     * @param userID
     * @param pageNum
     * @return
     */
    @GET("robert/customer")
    Observable<BaseBean<RobotPageBean>> queryMyRobotWithPage(@Header("Authorization") String auto
            , @Query("customer_id") int userID, @Query("pageNum") int pageNum);

    /**
     * 更新机器人相应
     * @param auto
     * @param robotID
     * @param body
     * @return
     */
    @PUT("robert/{id}")
    Observable<BaseBean<RobotMainBean>> updateRobot(@Header("Authorization") String auto, @Path("id") int robotID, @Body RequestBody body);

    /**
     * 删除对应机器人
     * @param auto
     * @param robotID
     * @return
     */
    @DELETE("robert/{id}")
    Observable<BaseBean> deleteRobot(@Header("Authorization") String auto,@Path("id") int robotID);

}

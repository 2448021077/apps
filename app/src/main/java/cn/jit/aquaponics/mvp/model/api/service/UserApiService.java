package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;
import cn.jit.aquaponics.mvp.model.entity.db.RoleUserInfoBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UserApiService {
    // 获取 用户列表
//    @GET("ac-service/user/expert")
//    Observable<BaseBean<PageBean<RoleUserInfo>>> queryRoleUserInfo(@Header("Authorization") String auto,
//                                                                       @Query("pageNum") int pageNum);

    // 获取 用户列表
    @GET("admin/lists")
    Observable<BaseBean<PageBean<RoleUserInfoBean>>> queryRoleUserInfo(@Header("Authorization") String auto,
                                                                       @Query("pageNum") int pageNum,
                                                                       @Query("role") int role);


    // 获取 用户列表
    @GET("user-center/admin/lists")
    Observable<BaseBean<PageBean<RoleUserInfoBean>>> queryRoleExpertInfo(@Header("Authorization") String auto,
                                                                             @Query("pageNum") int pageNum,
                                                                             @Query("role") int role);

}

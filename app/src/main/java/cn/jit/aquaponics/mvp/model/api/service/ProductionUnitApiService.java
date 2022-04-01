package cn.jit.aquaponics.mvp.model.api.service;

import java.util.List;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.CellBean;
import cn.jit.aquaponics.mvp.model.entity.db.CellProTypeBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductionUnitApiService {
    // 2 查询生产单元id
    @GET("micro-iot/celldef/listUserCells")
    Observable<BaseBean<PageBean<CellBean>>> getAllUserCells(@Header("Authorization") String auto,
                                                             @Query("username") String username,
                                                             @Query("pageNum") int pageNum);

    // 删除  生产单元
    @DELETE("micro-iot/celldef/delCell")
    Observable<BaseBean> deleteCell(@Header("Authorization") String auto,@Query("id") String id);

    // 增加 生产单元
    @POST("micro-iot/celldef/addCell")
    Observable<BaseBean<CellBean>>  addCell(@Header("Authorization") String auto,
                                                    @Query("length") double length,
                                                    @Query("width") double width,
                                                    @Query("longitude") double longitude,
                                                    @Query("latitude") double latitude,
                                                    @Query("cell_type") String product,
                                                    @Query("agri_prod") String prod,
                                                    @Query("cell_name") String cell_name,
                                                    @Query("user_name") String user_name);
    // 获取 生产单元 产品类型
    @GET("micro-iot/celldef/listCellTypes")
    Observable<BaseBean<List<CellProTypeBean>>> getCellProType(@Header("Authorization") String auto);

    // 获取 生产单元 产品
    @GET("micro-iot/celldef/listAgriProducts")
    Observable<BaseBean<String[]>> getCellPro(@Header("Authorization") String auto,@Query("celltype") String celltype);


}

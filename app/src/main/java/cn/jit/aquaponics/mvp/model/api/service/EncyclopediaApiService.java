package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaikeDiseaseBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaikeDrugBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaikeFeedBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaikeProductBean;
import cn.jit.aquaponics.mvp.model.entity.db.BaikeSeedBean;
import cn.jit.aquaponics.mvp.model.entity.db.CustomerInfoBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;
import cn.jit.aquaponics.mvp.model.entity.db.SelfInfoBean;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EncyclopediaApiService {
    /**
     * 专家信息
     * @param auto
     * @param pageNum
     * @return
     */
    @GET("expert/")
    Observable<BaseBean<PageBean<SelfInfoBean>>> queryExpertInfo(@Header("Authorization") String auto,
                                                                 @Query("pageNum") int pageNum);

    @GET("/customer/")
    Observable<BaseBean<PageBean<CustomerInfoBean>>> queryCustomerInfo(@Header("Authorization") String auto,
                                                                       @Query("pageNum") int pageNum);


    /**
     * 分页获得百科信息  品种
     * @param auto
     * @param subKind
     * @param pageNum
     * @return
     */
    @GET("crop/")
    Observable<BaseBean<PageBean<BaikeSeedBean>>> queryKindBaike(@Query("pageNum") int pageNum);

    /**
     * 分页获得百科信息 疾病
     * @param auto
     * @param subKind
     * @param pageNum
     * @return
     */
    @GET("disease/")
    Observable<BaseBean<PageBean<BaikeDiseaseBean>>> queryBingBaike(@Query("pageNum") int pageNum);

    /**
     * 分页获得百科信息 农药
     * @param auto
     * @param subKind
     * @param pageNum
     * @return
     */
    @GET("pesticide/")
    Observable<BaseBean<PageBean<BaikeDrugBean>>> queryYaoBaike(@Query("pageNum") int pageNum);

    /**
     * 分页获得百科信息  综合
     * @param auto
     * @param subKind
     * @param pageNum
     * @return
     */
    @GET("technology/")
    Observable<BaseBean<PageBean<BaikeFeedBean>>> queryWeiBaike(@Query("pageNum") int pageNum);

    /**
     * 分页获得百科信息 肥料
     * @param auto
     * @param subKind
     * @param pageNum
     * @return
     */
    @GET("fertilizer/")
    Observable<BaseBean<PageBean<BaikeProductBean>>> queryPinBaike(@Query("pageNum") int pageNum);


    /**
     * 获得详细的百科信息
     * @param auto
     * @param id
     * @return
     */
    @GET("crop/{id}")
    Observable<BaseBean<BaikeSeedBean>> queryDetailBaikeInfo( @Path("id") int id);


    /**
     * 获得详细的百科信息
     * @param auto
     * @param id
     * @return
     */
    @GET("disease/{id}")
    Observable<BaseBean<BaikeDiseaseBean>> queryDetailBingBaikeInfo(@Path("id") int id);



    /**
     * 获得详细的百科信息 药
     * @param auto
     * @param id
     * @return
     */
    @GET("pesticide/{id}")
    Observable<BaseBean<BaikeDrugBean>> queryDetailYaoBaikeInfo( @Path("id") int id);


    /**
     * 获得详细的百科信息
     * @param auto
     * @param id
     * @return
     */
    @GET("technology/{id}")
    Observable<BaseBean<BaikeFeedBean>> queryDetailWeiBaikeInfo( @Path("id") int id);


    /**
     * 获得详细的百科信息
     * @param auto
     * @param id
     * @return
     */
    @GET("fertilizer/{id}")
    Observable<BaseBean<BaikeProductBean>> queryDetailPinBaikeInfo( @Path("id") int id);

    /**
     * 种苗删除
     * @param auto
     * @param id
     * @return
     */
    @DELETE("crop/{ids}")
    Observable<BaseBean> deleteSeedBaikeByID(@Header("Authorization") String auto,@Path("ids") int id);

    /**
     * 物品删除
     * @param auto
     * @param id
     * @return
     */
    @DELETE("fertilizer/{ids}")
    Observable<BaseBean> deleteProductBaikeByID(@Header("Authorization") String auto,@Path("ids") int id);

    /**
     * 投喂删除
     * @param auto
     * @param id
     * @return
     */
    @DELETE("technology/{ids}")
    Observable<BaseBean> deleteFeedBaikeByID(@Header("Authorization") String auto,@Path("ids") int id);

    /**
     * 疾病删除
     * @param auto
     * @param id
     * @return
     */
    @DELETE("disease/{ids}")
    Observable<BaseBean> deleteDiseaseBaikeByID(@Header("Authorization") String auto,@Path("ids") int id);

    /**
     * 压迫你删除
     * @param auto
     * @param id
     * @return
     */
    @DELETE("pesticide/{ids}")
    Observable<BaseBean> deleteDrugBaikeByID(@Header("Authorization") String auto,@Path("ids") int id);


    @Multipart
    @POST("disease/add")
    Observable<BaseBean>  addDiseaseBaike(@Header("Authorization") String auto,
                                              @Query("diseaseName") String diseaseName,
                                              @Query("big_category") String bigCategory,
                                              @Query("symptom") String symptom,
                                              @Query("treatment") String treatment,
                                              @Part MultipartBody.Part image);

    @Multipart
    @PUT("disease/{id}")
    Observable<BaseBean<BaikeDiseaseBean>>  updateDiseaseBaikeWithPic(@Header("Authorization") String auto,
                                                                          @Path("id") int ID,
                                                                          @Query("diseaseName") String diseaseName,
                                                                          @Query("big_category") String subKind,
                                                                          @Query("symptom") String symptom,
                                                                          @Query("treatment") String treatment,
                                                                          @Part MultipartBody.Part image);

    @PUT("disease/{id}")
    Observable<BaseBean<BaikeDiseaseBean>>  updateDiseaseBaikeNoPic(@Header("Authorization") String auto,
                                                                        @Path("id") int ID,
                                                                        @Query("diseaseName") String diseaseName,
                                                                        @Query("big_category") String subKind,
                                                                        @Query("symptom") String symptom,
                                                                        @Query("treatment") String treatment);


    @POST("fertilizer/add")
    Observable<BaseBean>  addProductBaike(@Header("Authorization") String auto,
                                              @Body BaikeProductBean baikeProductBean);


//    @Multipart
//    @PUT("fertilizer/{id}")
//    Observable<BaseBean<BaikeProductBean>>  updateProductBaikeWithPic(@Header("Authorization") String auto,
//                                              @Path("id") int ID,
//                                              @Query("name") String name,
//                                              @Query("subKind") String subKind,
//                                              @Query("description") String description,
//                                              @Part MultipartBody.Part image);

    @PUT("fertilizer/{id}")
    Observable<BaseBean<BaikeProductBean>>  updateProductBaikeNoPic(@Header("Authorization") String auto,
                                                                        @Path("id") int ID,
                                                                        @Body BaikeProductBean baikeProductBean);


    @Multipart
    @POST("crop/add")
    Observable<BaseBean>  addSeedBaike(@Header("Authorization") String auto,
                                           @Query("name") String name,
                                           @Query("source") String source,
                                           @Query("content") String content,
                                           @Part MultipartBody.Part image);

    /**
     * 带有图片的更新种苗信息
     * @param auto
     * @param ID
     * @param title
     * @param subKind
     * @param price
     * @param productPlace
     * @param telPhone
     * @param contact
     * @param company
     * @param description
     * @param image
     * @return
     */
    @Multipart
    @PUT("crop/{id}")
    Observable<BaseBean<BaikeSeedBean>>  updateSeedBaikeWithPic(@Header("Authorization") String auto,
                                                                    @Path("id") int ID,
                                                                    @Query("name") String name,
                                                                    @Query("source") String source,
                                                                    @Query("content") String content,
                                                                    @Part MultipartBody.Part image);

    /**
     * 不带图片的更新种苗信息
     * @param auto
     * @param ID
     * @param title
     * @param subKind
     * @param price
     * @param productPlace
     * @param telPhone
     * @param contact
     * @param company
     * @param description
     * @return
     */
    @PUT("crop/{id}")
    Observable<BaseBean<BaikeSeedBean>>  updateSeedBaikeNoPic(@Header("Authorization") String auto,
                                                                  @Path("id") int ID,
                                                                  @Query("name") String name,
                                                                  @Query("source") String source,
                                                                  @Query("content") String content);



    @POST("technology/add")
    Observable<BaseBean>  addFeedBaike(@Header("Authorization") String auto,
                                           @Query("name") String name,
                                           @Query("category") String category,
                                           @Query("source") String source,
                                           @Query("content") String content);

//
//    @Multipart
//    @PUT("technology/{id}")
//    Observable<BaseBean<BaikeFeedBean>>  updateFeedBaikeWithPic(@Header("Authorization") String auto,
//                                           @Path("id") int ID,
//                                           @Query("name") String name,
//                                           @Query("subKind") String subKind,
//                                           @Query("price") String price,
//                                           @Query("telPhone") String telPhone,
//                                           @Query("contact") String contact,
//                                           @Query("company") String company,
//                                           @Query("manualInstruct") String manualInstruct,
//                                           @Part MultipartBody.Part image);

    @PUT("technology/{id}")
    Observable<BaseBean<BaikeFeedBean>>  updateFeedBaikeNoPic(@Header("Authorization") String auto,
                                                                  @Path("id") int ID,
                                                                  @Query("name") String name,
                                                                  @Query("category") String category,
                                                                  @Query("source") String source,
                                                                  @Query("content") String content);



    @POST("pesticide/add")
    Observable<BaseBean>  addDrugBaike(@Header("Authorization") String auto,
                                           @Body BaikeDrugBean baikeDrugBean);

//    @Multipart
//    @PUT("pesticide/{id}")
//    Observable<BaseBean<BaikeDrugBean>>  updateDrugBaikeWithPic(@Header("Authorization") String auto,
//                                                                    @Path("id") int ID,
//                                           @Query("name") String name,
//                                           @Query("subKind") String subKind,
//                                           @Query("price") String price,
//                                           @Query("telPhone") String telPhone,
//                                           @Query("contact") String contact,
//                                           @Query("company") String company,
//                                           @Query("manualInstruct") String manualInstruct,
//                                           @Part MultipartBody.Part image);

    @PUT("pesticide/{id}")
    Observable<BaseBean<BaikeDrugBean>>  updateDrugBaikeNoPic(@Header("Authorization") String auto,
                                                                  @Path("id") int ID,
                                                                  @Body BaikeDrugBean baikeDrugBean);


}

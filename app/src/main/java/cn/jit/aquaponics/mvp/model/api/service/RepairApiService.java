package cn.jit.aquaponics.mvp.model.api.service;

import cn.jit.aquaponics.base.BaseBean;
import cn.jit.aquaponics.base.BaseListBean;
import cn.jit.aquaponics.mvp.model.entity.db.AnswerBean;
import cn.jit.aquaponics.mvp.model.entity.db.PageBean;
import cn.jit.aquaponics.mvp.model.entity.db.QuestionBean;
import cn.jit.aquaponics.mvp.model.entity.db.QuestionListBean;
import cn.jit.aquaponics.mvp.model.entity.db.RepairStateBean;
import cn.jit.aquaponics.mvp.model.entity.db.SelfInfoBean;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepairApiService {
    /**
     * 用户维修列表
     * @param auto 用户token
     * @return  listBean
     */
    @GET("customer/repair/list")
    Observable<BaseListBean<RepairStateBean>> queryRepairStateList(@Header("Authorization") String auto);


    @POST("customer/repair/{robert_id}")
    Observable<BaseBean> addRobotNeededRepair(@Header("Authorization") String auto,
                                              @Path("robert_id") int robertID,
                                              @Query("description") String description);

    @Multipart
    @POST("feedback/")
    Observable<BaseBean>  opinionFeedback(@Header("Authorization") String auto,
                                              @Query("description") String description,
                                              @Query("contact") String contact,
                                              @Part MultipartBody.Part image);

    @POST("feedback/")
    Observable<BaseBean>  opinionFeedbackNopic(@Header("Authorization") String auto,
                                                   @Query("description") String description,
                                                   @Query("contact") String contact);

    /**
     * 查询普通用户个人信息
     * @param auto
     * @return
     */
    @GET("customer/get")
    Observable<BaseBean<SelfInfoBean>> queryUserInfo(@Query("username") String userName);

    /**
     * 修改普通用户个人信息
     * @param auto
     * @param body
     * @return
     */
    @PUT("customer/update")
    Observable<BaseBean> updateUserInfo(@Header("Authorization") String auto,@Query("customer") String customer,@Body RequestBody body);


    @GET("user/check")
    Observable<BaseBean> userCheck(@Query("name") String name);

    @PUT("user/edit")
    Observable<BaseBean> forgetPass(@Query("tel") String tel,@Query("password") String pass,@Query("password1") String pass1);


    /**
     * 查询普专家户个人信息
     * @param auto
     * @return
     */
    @GET("expert/get")
    Observable<BaseBean<SelfInfoBean>> queryExpertInfo(@Query("username") String userName);

    /**
     * 修改专家用户个人信息
     * @param auto
     * @param body
     * @return
     */
    @PUT("expert/update")
    Observable<BaseBean> updateExpertInfo(@Header("Authorization") String auto,@Query("expert") String customer,@Body RequestBody body);


    /**
     * 查询问题列表
     * @param auto
     * @return
     */
    @GET("ac-service/question/")
    Observable<BaseBean<PageBean<QuestionListBean>>> queryQuestionlist(@Header("Authorization") String auto,
                                                                       @Query("pageNum") int pageNum);


    /**
     * 查询某条问题
     * @param auto
     * @return
     */
    @GET("ac-service/question/{id}")
    Observable<BaseBean<QuestionListBean>> queryOneQuestion(@Header("Authorization") String auto,
                                                                @Path("id") int ID);


    /**
     * 增加回答
     * @param auto
     * @return
     */
    @POST("ac-service/answer/add")
    Observable<BaseBean<AnswerBean>>  answerQuestion(@Header("Authorization") String auto,
                                                     @Query("content") String content,
                                                     @Query("question_id") int questionID);


    /**
     * 增加回答
     * @param auto
     * @return
     */
    @Multipart
    @POST("ac-service/question/add")
    Observable<BaseBean<QuestionBean>>  askQuestionWithImage(@Header("Authorization") String auto,
                                                             @Query("description") String des,
                                                             @Part MultipartBody.Part image);


    @POST("ac-service/question/add")
    Observable<BaseBean<QuestionBean>>  askQuestion(@Header("Authorization") String auto,
                                                        @Query("description") String des);

}

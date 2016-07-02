package adamin90.com.qqd.service;

import adamin90.com.qqd.moled.code.CodeModel;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by LiTao on 2015-11-28-17:11.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 * signature :
 * \8d9292c03050ba732ba2e45a53460e1cdf47c8b4
 * nonce :1360000000
 */
public interface Code {
/*{"result":"success","uid":"8481196"}*/
    @FormUrlEncoded
    @POST("imobile/newregsec.php")
    Observable<CodeModel> restMobile(@Field("phone") String phone,@Field("timestamp") String timesamp,
                                     @Field("signature") String signature,@Field("action") String action,
                                     @Field("nonce") String nonce);
}

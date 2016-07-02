package adamin90.com.qqd.service;

import adamin90.com.qqd.moled.detail.Detail;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by LiTao on 2016-01-15-11:20.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public interface DetailService {
    @GET("imobile/topic_new.php?dev=mobileclub")
    Observable<Detail> getDetails(@Query("topic_id") String topic_id,@Query("board_id") String board_id
    ,@Query("page") int page);
}

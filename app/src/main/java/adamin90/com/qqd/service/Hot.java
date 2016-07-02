package adamin90.com.qqd.service;

import adamin90.com.qqd.moled.hot.HotModel;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by LiTao on 2015-11-29-16:19.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 * imobile/index.php?title=头条&page=1
 */
public interface Hot {
    @GET("imobile/index.php")
    Observable<HotModel> getHot(@Query("title") String title,@Query("page") int page);
}

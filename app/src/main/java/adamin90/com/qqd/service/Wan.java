package adamin90.com.qqd.service;

import adamin90.com.qqd.moled.fun.WanModel;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by LiTao on 2015-11-29-16:09.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 * 去玩
 */
public interface Wan {
    @GET("imobile/wan/list.php")
    Observable<WanModel> getWan(@Query("page") int page);
}

package adamin90.com.qqd.service;

import adamin90.com.qqd.models.album.AlbumData;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;

/**
 * Created by LiTao on 2015-12-25-22:07.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 * http://a.4493.com
 */
public interface MeiziService {

    @Headers({
            "Host: a.4493.com",
            "User-Agent: 21",
            "Content-Type: text/plain; charset=UTF-8"
    })
    @Multipart
    @POST("rest/")
    Observable<AlbumData> getAlbumData(
            @Part(value = "appkey",encoding="8bit") String appkey, @Part(value = "channel_id",encoding="8bit") String channelid,
            @Part(value = "crc",encoding="8bit") String crc
    , @Part(value = "page",encoding="8bit") int page, @Part(value = "pagesize",encoding="8bit") int pagesize
    , @Part(value = "ver",encoding="8bit") String ver, @Part(value = "api",encoding="8bit") String api,
            @Part(value = "market",encoding="8bit") String market, @Part(value = "version",encoding="8bit") String version,@Part(value = "keyword",encoding="8bit") String key);
}

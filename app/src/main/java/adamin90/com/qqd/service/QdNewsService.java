package adamin90.com.qqd.service;

import adamin90.com.qqd.moled.qdnews.QdNewsDataWrapper;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * //
 * //         Created by LiTao on 2016-03-01-13:30.
 * //         Company: QD24so
 * //         Email: 14846869@qq.com
 * //         WebSite: http://lixiaopeng.top
 * //
 * http://app.qingdaonews.com/shoujikehuduan/mdi_newslist300.php?v=2.0&num=20&type=bd&minid=407066
 */
public interface QdNewsService {
    interface  List{
        /*type  头条 bd 焦点  jdxw 体育 ty   文娱 yl 家居 qdjj
        * 财经 cj 教育 jy  健康 jk 消费 xf 舆情 yuqing  婚嫁 hj
        * 民生 msbl  崂山 laoshan  房产 qdfc 青岛早报 zaobao
        * 青岛晚报 wanbao  青岛日报  ribao  老年生活报  loanianbao
        * 吃喝玩乐 chihe   青岛早知道  zaozhidao  青岛心发现  xinfaxian
        * 张岩拍青岛  zhangyan 张大早报  zhangda  在青岛  inqd
        * 旅游  qdly 电商 ds  黄岛 huangdao 汽车  汽车 qdqc
        * 市南 shinan 李沧 licang 市北 shibei  城阳 chengyang 即墨 jimo
        * 胶州 jiaozhou 莱西laixi 平度 pingdu */
        @GET("mdi_newslist300.php?v=2.0")
        Observable<String> getNewList(@Query("num") String num,@Query("type") String type,
                                                 @Query("minid") String minid);
    }
}

package adamin90.com.qqd.moled.qdnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
 * //         Created by LiTao on 2016-03-01-13:19.
 * //         Company: QD24so
 * //         Email: 14846869@qq.com
 * //         WebSite: http://lixiaopeng.top
 * //
 */
public class QdNewsDataWrapper {
    @SerializedName("data")
    @Expose
    private Object [] data = new Object[]{};
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("imgurl")
    @Expose
    private String imgurl;

    /**
     *
     * @return
     * The data
     */
    public Object[] getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Object[] data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The num
     */
    public String getNum() {
        return num;
    }

    /**
     *
     * @param num
     * The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     *
     * @return
     * The last
     */
    public String getLast() {
        return last;
    }

    /**
     *
     * @param last
     * The last
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The imgurl
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     *
     * @param imgurl
     * The imgurl
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}

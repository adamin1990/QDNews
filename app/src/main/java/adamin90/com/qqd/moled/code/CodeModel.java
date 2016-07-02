package adamin90.com.qqd.moled.code;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LiTao on 2015-11-28-17:09.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class CodeModel {

    @SerializedName("result")
    @Expose
    private  String result;

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("info")
    @Expose
    private String info;
    /**
     *
     * @return
     * The result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The uid
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     * The uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

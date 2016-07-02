
package adamin90.com.qqd.moled.wandetail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Rdata {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("un")
    @Expose
    private String un;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("addtime")
    @Expose
    private String addtime;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * 
     * @param cid
     *     The cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * 
     * @return
     *     The uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 
     * @param uid
     *     The uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 
     * @return
     *     The un
     */
    public String getUn() {
        return un;
    }

    /**
     * 
     * @param un
     *     The un
     */
    public void setUn(String un) {
        this.un = un;
    }

    /**
     * 
     * @return
     *     The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The addtime
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * 
     * @param addtime
     *     The addtime
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}


package adamin90.com.qqd.moled.detail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Master {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("face")
    @Expose
    private String face;
    @SerializedName("uid")
    @Expose
    private String uid;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The master
     */
    public String getMaster() {
        return master;
    }

    /**
     * 
     * @param master
     *     The master
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The main
     */
    public String getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * 
     * @return
     *     The createAt
     */
    public String getCreateAt() {
        return createAt;
    }

    /**
     * 
     * @param createAt
     *     The create_at
     */
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    /**
     * 
     * @return
     *     The face
     */
    public String getFace() {
        return face;
    }

    /**
     * 
     * @param face
     *     The face
     */
    public void setFace(String face) {
        this.face = face;
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

}

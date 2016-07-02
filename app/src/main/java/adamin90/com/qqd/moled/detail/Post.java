
package adamin90.com.qqd.moled.detail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Post {

    @SerializedName("floor")
    @Expose
    private Integer floor;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("uid")
    @Expose
    private String uid;

    /**
     * 
     * @return
     *     The floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 
     * @param floor
     *     The floor
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * 
     * @return
     *     The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(String author) {
        this.author = author;
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
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
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

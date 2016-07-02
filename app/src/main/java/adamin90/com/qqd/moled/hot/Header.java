
package adamin90.com.qqd.moled.hot;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Header{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("board_id")
    @Expose
    private String boardId;
    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @SerializedName("board_name")
    @Expose
    private String boardName;

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * 
     * @param pic
     *     The pic
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The boardId
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * 
     * @param boardId
     *     The board_id
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    /**
     * 
     * @return
     *     The topicId
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 
     * @param topicId
     *     The topic_id
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    /**
     * 
     * @return
     *     The boardName
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * 
     * @param boardName
     *     The board_name
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

}

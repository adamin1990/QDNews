
package adamin90.com.qqd.models.album;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class List {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("item_num")
    @Expose
    private Integer itemNum;
    @SerializedName("zan")
    @Expose
    private Integer zan;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The itemNum
     */
    public Integer getItemNum() {
        return itemNum;
    }

    /**
     * 
     * @param itemNum
     *     The item_num
     */
    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * 
     * @return
     *     The zan
     */
    public Integer getZan() {
        return zan;
    }

    /**
     * 
     * @param zan
     *     The zan
     */
    public void setZan(Integer zan) {
        this.zan = zan;
    }

}

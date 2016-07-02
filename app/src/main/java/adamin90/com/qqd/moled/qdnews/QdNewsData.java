
package adamin90.com.qqd.moled.qdnews;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class QdNewsData {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("cate")
    @Expose
    private String cate;
    @SerializedName("memo")
    @Expose
    private String memo;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("newstype")
    @Expose
    private String newstype;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("cnm")
    @Expose
    private String cnm;
    @SerializedName("imgs")
    @Expose
    @Nullable
    private List<Images> images=new ArrayList<>();

    @Nullable
    public List<Images> getImages() {
        return images;
    }

    public void setImages(@Nullable List<Images> images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     * The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     * The cate
     */
    public String getCate() {
        return cate;
    }

    /**
     *
     * @param cate
     * The cate
     */
    public void setCate(String cate) {
        this.cate = cate;
    }

    /**
     *
     * @return
     * The memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     *
     * @param memo
     * The memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     *
     * @return
     * The img
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     * The img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The newstype
     */
    public String getNewstype() {
        return newstype;
    }

    /**
     *
     * @param newstype
     * The newstype
     */
    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The cnm
     */
    public String getCnm() {
        return cnm;
    }

    /**
     *
     * @param cnm
     * The cnm
     */
    public void setCnm(String cnm) {
        this.cnm = cnm;
    }

}

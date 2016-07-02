
package adamin90.com.qqd.models.album;

import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("page_info")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("list")
    @Expose
    private java.util.List<adamin90.com.qqd.models.album.List> list = new ArrayList<adamin90.com.qqd.models.album.List>();

    /**
     * 
     * @return
     *     The pageInfo
     */
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    /**
     * 
     * @param pageInfo
     *     The page_info
     */
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<adamin90.com.qqd.models.album.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<adamin90.com.qqd.models.album.List> list) {
        this.list = list;
    }

}

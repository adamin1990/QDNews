
package adamin90.com.qqd.moled.hot;

import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HotModel {

    @SerializedName("header")
    @Expose
    private java.util.List<Header> header = new ArrayList<Header>();
    @SerializedName("tools")
    @Expose
    private java.util.List<Tool> tools = new ArrayList<Tool>();
    @SerializedName("list")
    @Expose
    private java.util.List<adamin90.com.qqd.moled.hot.List> list = new ArrayList<adamin90.com.qqd.moled.hot.List>();
    @SerializedName("sum")
    @Expose
    private String sum;

    /**
     * 
     * @return
     *     The header
     */
    public java.util.List<Header> getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    public void setHeader(java.util.List<Header> header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The tools
     */
    public java.util.List<Tool> getTools() {
        return tools;
    }

    /**
     * 
     * @param tools
     *     The tools
     */
    public void setTools(java.util.List<Tool> tools) {
        this.tools = tools;
    }

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<adamin90.com.qqd.moled.hot.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<adamin90.com.qqd.moled.hot.List> list) {
        this.list = list;
    }

    /**
     * 
     * @return
     *     The sum
     */
    public String getSum() {
        return sum;
    }

    /**
     * 
     * @param sum
     *     The sum
     */
    public void setSum(String sum) {
        this.sum = sum;
    }

}


package adamin90.com.qqd.moled.fun;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class WanModel {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("datas")
    @Expose
    private List<Data> datas = new ArrayList<Data>();
    @SerializedName("types")
    @Expose
    private Object types;

    /**
     * 
     * @return
     *     The result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 
     * @return
     *     The info
     */
    public String getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The datas
     */
    public List<Data> getDatas() {
        return datas;
    }

    /**
     * 
     * @param datas
     *     The datas
     */
    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    /**
     * 
     * @return
     *     The types
     */
    public Object getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(Object types) {
        this.types = types;
    }

}

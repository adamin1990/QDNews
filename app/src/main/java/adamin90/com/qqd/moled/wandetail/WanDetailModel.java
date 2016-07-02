
package adamin90.com.qqd.moled.wandetail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class WanDetailModel {

    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("datas")
    @Expose
    private Datas datas;
    @SerializedName("types")
    @Expose
    private Types types;

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
     *     The datas
     */
    public Datas getDatas() {
        return datas;
    }

    /**
     * 
     * @param datas
     *     The datas
     */
    public void setDatas(Datas datas) {
        this.datas = datas;
    }

    /**
     * 
     * @return
     *     The types
     */
    public Types getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(Types types) {
        this.types = types;
    }

}

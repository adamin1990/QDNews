
package adamin90.com.qqd.moled.detail;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Detail {

    @SerializedName("html")
    @Expose
    private Html html;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("page_total")
    @Expose
    private Integer pageTotal;
    @SerializedName("board")
    @Expose
    private Board board;

    /**
     * 
     * @return
     *     The html
     */
    public Html getHtml() {
        return html;
    }

    /**
     * 
     * @param html
     *     The html
     */
    public void setHtml(Html html) {
        this.html = html;
    }

    /**
     * 
     * @return
     *     The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The pageTotal
     */
    public Integer getPageTotal() {
        return pageTotal;
    }

    /**
     * 
     * @param pageTotal
     *     The page_total
     */
    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    /**
     * 
     * @return
     *     The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * 
     * @param board
     *     The board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

}

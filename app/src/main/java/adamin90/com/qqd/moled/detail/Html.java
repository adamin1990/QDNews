
package adamin90.com.qqd.moled.detail;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Html {

    @SerializedName("master")
    @Expose
    private Master master;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<Post>();

    /**
     * 
     * @return
     *     The master
     */
    public Master getMaster() {
        return master;
    }

    /**
     * 
     * @param master
     *     The master
     */
    public void setMaster(Master master) {
        this.master = master;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}

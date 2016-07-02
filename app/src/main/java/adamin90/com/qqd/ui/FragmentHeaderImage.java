package adamin90.com.qqd.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import adamin90.com.qqd.R;
import adamin90.com.qqd.moled.hot.Header;
import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by LiTao on 2015-12-03-13:06.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class FragmentHeaderImage extends Fragment {

private String header;



//    public static  Fragment newInstance(String url){
//        FragmentHeaderImage fragmentHeaderImage=new FragmentHeaderImage();
//        Bundle bundle=new Bundle();
//        bundle.putString("header",url);
//        fragmentHeaderImage.setArguments(bundle);
//        return  fragmentHeaderImage;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_pager_header,container,false);
        ButterKnife.bind(this,view);
        Timber.e("图片地址"+header);
        init();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();



        }


    private void init() {
        if(getArguments()!=null){
            header=  getArguments().getString("header");

        }
    }
}

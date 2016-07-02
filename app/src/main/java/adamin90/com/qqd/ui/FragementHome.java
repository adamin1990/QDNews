package adamin90.com.qqd.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import adamin90.com.qqd.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LiTao on 2015-11-29-14:07.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class FragementHome extends Fragment {

    @Bind(android.R.id.tabhost)
    FragmentTabHost fragmentTabHost;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragmenthome,null);
        ButterKnife.bind(this,view);
        fragmentTabHost.setup(getActivity(),getActivity().getSupportFragmentManager(),android.R.id.tabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("第一个").setIndicator(getIndicator(0)),Fragement2.class,null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("第2个").setIndicator(getIndicator(1)),FragmentContent.class,null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("第3个").setIndicator(getIndicator(2)),FragmentHeaderImage.class,null);
//        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("第4个").setIndicator(getIndicator(3)),FragmentHeaderImage.class,null);
        return view;
    }    private View getIndicator(int index) {
        TextView textView = (TextView) View.inflate(getActivity(),
                R.layout.indicator_view, null);
        textView.setEnabled(true);
        switch (index){
            case 0:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
                        .getDrawable(R.drawable.tab_home_btn), null, null);
                textView.setText("社区");
                break;
            case 1:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
                        .getDrawable(R.drawable.tab_activity_tbn), null, null);
                textView.setText("活动");
                break;
            case 2:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
                        .getDrawable(R.drawable.tab_home_btn), null, null);
                textView.setText("新闻");
                break;
            case 3:
                textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
                        .getDrawable(R.drawable.tab_home_btn), null, null);
                textView.setText("我的");
                break;
        }

        return textView;
    }


}

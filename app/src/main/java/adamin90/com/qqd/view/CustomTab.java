package adamin90.com.qqd.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

import adamin90.com.qqd.R;

/**
 * Created by LiTao on 2015-11-30-23:02.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class CustomTab extends TabLayout {
    public CustomTab(Context context) {
        super(context);
    }

    public CustomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
//        removeAllTabs();
//        for (int i = 0, count = adapter.getCount(); i < count; i++) {
//            addTab(newTab().setText(adapter.getPageTitle(i)).setIcon(R.mipmap.ic_launcher));
//        }
//    }
}

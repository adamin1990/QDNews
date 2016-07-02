package adamin90.com.qqd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adamin90.com.qqd.Constant;
import adamin90.com.qqd.EncryptionUtil;
import adamin90.com.qqd.R;
import adamin90.com.qqd.event.TitleEvent;
import adamin90.com.qqd.models.album.AlbumData;
import adamin90.com.qqd.service.MeiziService;
import adamin90.com.qqd.utils.LogUtil;
import adamin90.com.qqd.view.CustomTab;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by LiTao on 2015-11-29-21:44.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class Fragement2 extends Fragment {
    @Bind(R.id.tablayout)
    CustomTab customTab;
    @Bind(R.id.viewpager)
    ViewPager pager;
    private  Adapter adapter;
    private  String title="";

//    private Retrofit retrofit;
//    private MeiziService meiziService;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           View view=inflater.inflate(R.layout.frament2,container,false);
        LogUtil.error(Fragement2.class,"oncreateView");
        ButterKnife.bind(this,view);
        setupViewPager(pager);

        customTab.post(new Runnable() {
            @Override
            public void run() {
                        customTab.setupWithViewPager(pager);

            }
        });
        getData();

        return view;
    }

    private void getData() {
//        retrofit=new Retrofit.Builder()
//                .baseUrl(Constant.MEIZHIBASEURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        meiziService=retrofit.create(MeiziService.class);
//        String prex="api="+Constant.MEIZHIALBUM+"&"+"channel_id="+"8"+"&"+"keyword="+ ""+"&"+"page=1"+"&"+"pagesize=20"
//                +"&"+"market="+"4493"+"&"+"version=2.0.2";
//        LogUtil.error(Fragement2.class,prex);
//        LogUtil.error(Fragement2.class,EncryptionUtil.SHA1(prex+Constant.MEIZHIREX));
//        meiziService.getAlbumData(Constant.MEIZHIAPPKEY,"8",EncryptionUtil.getSHA1Str(prex+Constant.MEIZHIREX),1
//        ,20,"1.0",Constant.MEIZHIALBUM,"4493","2.0.2","")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<AlbumData>() {
//                    @Override
//                    public void call(AlbumData albumData) {
//                        Timber.e(albumData.getData().getPageInfo().getMedia()+"妹子对");
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Timber.e(throwable.toString()+"妹子错");
//                    }
//                });

    }

    private void setupViewPager(final ViewPager viewPager) {
        LogUtil.error(Fragement2.class,"setUpViewPager");
         adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment( FragmentNested.newInstance("头条"), "头条");
        adapter.addFragment( FragmentNested.newInstance("活动"), "活动");
        adapter.addFragment( FragmentNested.newInstance("房产"), "房产");
        adapter.addFragment( FragmentNested.newInstance("购物"), "购物");
        adapter.addFragment( FragmentNested.newInstance("亲子"), "亲子");
        adapter.addFragment( FragmentNested.newInstance("家居"), "家居");
        adapter.addFragment( FragmentNested.newInstance("婚嫁"), "婚嫁");
        adapter.addFragment( FragmentNested.newInstance("美食"), "美食");
        adapter.addFragment( FragmentNested.newInstance("旅游"), "旅游");
        adapter.addFragment( FragmentNested.newInstance("汽车"), "汽车");
        adapter.addFragment( FragmentNested.newInstance("健康"), "健康");
        adapter.addFragment( FragmentNested.newInstance("教育"), "教育");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                EventBus.getDefault().post(new TitleEvent(adapter.getPageTitle(position)+""));
                title=adapter.getPageTitle(position)+"";
                LogUtil.error(Fragement2.class,"onpageselect"+position);
                LogUtil.error(Fragement2.class,adapter.getPageTitle(position)+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Intent intent=new Intent(HomeActivity.ACTION_CHANGE_TITLE);
        intent.putExtra("title",title.equals("")?"头条":title);
        getContext().sendBroadcast(intent);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}

package adamin90.com.qqd.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.adamin.superrecyclerview.animator.adapters.SlideInLeftAnimationAdapter;
import com.adamin.superrecyclerview.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adamin90.com.qqd.Constant;
import adamin90.com.qqd.R;
import adamin90.com.qqd.adapter.HotAdapter;
import adamin90.com.qqd.event.TitleEvent;
import adamin90.com.qqd.moled.hot.Header;
import adamin90.com.qqd.moled.hot.HotModel;
import adamin90.com.qqd.service.Hot;
import adamin90.com.qqd.utils.LogUtil;
import adamin90.com.qqd.view.LinePageIndicator;
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
 * Created by LiTao on 2015-11-30-23:13.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class FragmentNested extends Fragment {
//    @Bind(R.id.swiperefresh)
//    SwipeRefreshLayout swipeRefreshLayout;
//    @Bind(R.id.header)
//    ViewPager pager;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
//    @Bind(R.id.indicator)
    LinePageIndicator linePageIndicator;
//    @Bind(R.id.fragment_nest_vp)
//    FrameLayout frameLayout;


    private Retrofit retrofit;
    Hot hot;
    OkHttpClient okHttpClient=new OkHttpClient();

    private String title ;
    private int page = 1;
    private java.util.List<Header> headerList;
    private List<adamin90.com.qqd.moled.hot.List> listList;
    private LinearLayoutManager linearLayoutManager;
//    private HeaderPagerAdapter headerPagerAdapter;
    private HotAdapter hotAdapter;
//    private ImageAdapter imageAdapter;
    private AlertDialog alertDialog;

    private boolean isLoadingMore=false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentnested, container, false);
        ButterKnife.bind(this, view);
//        linePageIndicator.setViewPager(pager);
        init();
        LogUtil.error(FragmentNested.class,"onCreate"+title);
        setListener();
         MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON,"json");
        final Request request=new Request.Builder().url("http://app.qingdaonews.com/shoujikehuduan/mdi_newslist300.php?v=2.0&num=20&type=jk")
                .post(body)
                .build();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Response response= null;
                    try {
                        response = okHttpClient.newCall(request).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        JSONObject jb=new JSONObject(response.body().string());
                        JSONArray ja=jb.getJSONArray("data");
                        JSONArray ja2=ja.getJSONArray(0);
                        JSONObject jsonObject=ja.getJSONObject(1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        LogUtil.error(FragmentNested.class,e.toString());
                        e.printStackTrace();
                    }
                }
            }).start();


        return view;
    }

    private void setListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition=linearLayoutManager.findLastVisibleItemPosition();
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                if (((totalItemCount - lastVisibleItemPosition) <= 10 ||
                        (totalItemCount - lastVisibleItemPosition) == 0 && totalItemCount > visibleItemCount)
                        && !isLoadingMore){
                    page++;
                    getMoreData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void getMoreData() {

        alertDialog.show();
        hot.getHot(title, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotModel>() {
                    @Override
                    public void call(HotModel hotModel) {

                        if(hotModel.getHeader().size()==0||hotModel.getHeader()==null){


                        }else {
                            headerList.addAll(hotModel.getHeader());

                        }

                        listList.addAll(hotModel.getList());
                        hotAdapter.notifyDataSetChanged();
                        alertDialog.dismiss();
                        isLoadingMore=false;
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.e("错误是多少"+throwable.toString());
                        alertDialog.dismiss();
                        isLoadingMore=false;
                    }
                });

    }


    public static Fragment newInstance(String title) {
        FragmentNested fragmentNested = new FragmentNested();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragmentNested.setArguments(bundle);
        return fragmentNested;
    }

    void init() {
        alertDialog=new AlertDialog.Builder(getActivity())
                .setCancelable(false)
                .setView(R.layout.progress_layout)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        hot = retrofit.create(Hot.class);
        headerList = new ArrayList<>();
        listList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        hotAdapter=new HotAdapter(listList,headerList);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).build());
        recyclerView.setAdapter(new SlideInLeftAnimationAdapter(hotAdapter));
        title = getArguments().getString("title");
        alertDialog.show();
        hot.getHot(title, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotModel>() {
                    @Override
                    public void call(HotModel hotModel) {
                        if(hotModel.getHeader().size()==0||hotModel.getHeader()==null){
//                            frameLayout.setVisibility(View.GONE);


                        }else {
//                            frameLayout.setVisibility(View.VISIBLE);
                            headerList.addAll(hotModel.getHeader());
//                            imageAdapter=new ImageAdapter(headerList);
//                            headerPagerAdapter = new HeaderPagerAdapter(getActivity().getSupportFragmentManager(),getActivity(), headerList);
//                            pager.setAdapter(headerPagerAdapter);
//                            headerPagerAdapter.notifyDataSetChanged();
//                            pager.setAdapter(imageAdapter);
//                            imageAdapter.notifyDataSetChanged();
//                            linePageIndicator.setViewPager(pager);
                        }

                        listList.addAll(hotModel.getList());
                        hotAdapter.notifyDataSetChanged();
                        alertDialog.dismiss();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.e("错误是多少"+throwable.toString());
                        alertDialog.dismiss();
                    }
                });


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroy() {


        super.onDestroy();

    }

    @Override
    public void onStop() {

        super.onStop();
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    class ImageAdapter extends PagerAdapter{
        private List<Header> headerList;

        public ImageAdapter(List<Header> headerList) {
            this.headerList = headerList;
        }

        @Override
        public int getCount() {
            return headerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view==object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            ImageView imageView=new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout .LayoutParams.MATCH_PARENT, 250));
            if(headerList.size()!=0&&headerList!=null){
                Picasso.with(getActivity()).load(headerList.get(position).getPic())
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Timber.e("Picasso失败"+headerList.get(position).getPic());

                            }
                        });
            }

            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((ImageView)object);
        }


    }
}

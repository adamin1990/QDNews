package adamin90.com.qqd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adamin90.com.qqd.App;
import adamin90.com.qqd.Constant;
import adamin90.com.qqd.R;
import adamin90.com.qqd.adapter.WanAdater;
import adamin90.com.qqd.inter.OnToolbarLinsener;
import adamin90.com.qqd.moled.fun.Data;
import adamin90.com.qqd.moled.fun.WanModel;
import adamin90.com.qqd.service.Wan;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by LiTao on 2015-11-29-15:14.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class FragmentContent extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private List<Data> datas;
    private Wan wan;
    private WanAdater wanAdater;
    private OnToolbarLinsener linsener;
    private Retrofit retrofit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentcontent,null);
        ButterKnife.bind(this,view);
        init();
        Intent intent=new Intent();
        intent.setAction(HomeActivity.ACTION_CHANGE_TITLE);
        intent.putExtra("title","周边活动");
        getContext().sendBroadcast(intent);
        return view;
    }
    void setListener(OnToolbarLinsener listener){
        this.linsener=listener;
    }
    private void init() {
        retrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        datas=new ArrayList<>();
        linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent
        ,R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(this);
        wan= retrofit.create(Wan.class);
        wanAdater=new WanAdater(datas);
        recyclerView.setAdapter(wanAdater);
        if(linsener!=null){
            linsener.setTitle("活动");
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout.setRefreshing(true);
        getData();
    }

    private void getData() {
        wan.getWan(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WanModel>() {
                    @Override
                    public void call(WanModel wanModel) {
                        datas.addAll(wanModel.getDatas());
                        wanAdater.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Snackbar.make(recyclerView,"出错了~"+throwable.toString(),Snackbar.LENGTH_INDEFINITE).show();
                    }
                });
    }

    @Override
    public void onRefresh() {
        Snackbar.make(recyclerView,"刷新",Snackbar.LENGTH_SHORT).show();
        datas.clear();
        wanAdater.notifyDataSetChanged();
      getData();
    }

}

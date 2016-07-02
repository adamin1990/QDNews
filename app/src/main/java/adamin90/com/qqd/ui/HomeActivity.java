package adamin90.com.qqd.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import adamin90.com.qqd.R;
import adamin90.com.qqd.event.TitleEvent;
import adamin90.com.qqd.inter.OnToolbarLinsener;
import adamin90.com.qqd.moled.qdnews.QdNewsData;
import adamin90.com.qqd.moled.qdnews.QdNewsDataWrapper;
import adamin90.com.qqd.service.QdNewsService;
import adamin90.com.qqd.service.RetrofitNetWork;
import adamin90.com.qqd.utils.LogUtil;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnToolbarLinsener {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.contanier)
    FrameLayout frameLayout;
    public static final String ACTION_CHANGE_TITLE = "ACTION_CHANGE_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.contanier, new FragementHome())
                .commit();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CHANGE_TITLE);
        registerReceiver(titleRecerver, intentFilter);
        RetrofitNetWork.retrofit.create(QdNewsService.List.class)
                .getNewList("20", "bd", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.error(HomeActivity.class, e.getMessage());

                    }

                    @Override
                    public void onNext(String qdNewsDataWrapper) {
                        LogUtil.error(HomeActivity.class, "成功" + qdNewsDataWrapper);
                        fetchData(qdNewsDataWrapper);

                    }
                });


    }

    private void fetchData(String qdNewsDataWrapper) {
        try {
            JSONObject jsonObject = new JSONObject(qdNewsDataWrapper);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            JSONArray jsonArray1 = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++) {
                if (i == 0) {
                    jsonArray1 = jsonArray.getJSONArray(i);
                } else {

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
        LogUtil.error(HomeActivity.class, "设置标题" + title);
    }


    public void onEvent(TitleEvent titleEvent) {
        getSupportActionBar().setTitle(titleEvent.getTitle());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unregisterReceiver(titleRecerver);

    }

    BroadcastReceiver titleRecerver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_CHANGE_TITLE)) {
                getSupportActionBar().setTitle(intent.getStringExtra("title"));
            }
        }
    };
}

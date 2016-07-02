package adamin90.com.qqd.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import adamin90.com.qqd.Constant;
import adamin90.com.qqd.R;
import adamin90.com.qqd.moled.detail.Detail;
import adamin90.com.qqd.moled.detail.Master;
import adamin90.com.qqd.moled.detail.Post;
import adamin90.com.qqd.service.DetailService;
import adamin90.com.qqd.utils.LogUtil;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class QqdWebActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webview)
    WebView webView;
    private Retrofit retrofit;
    private DetailService detailService;
    private int page = 1;
    private int totolepage = 1;
    private String topic_id;
    private String board_id;
    private Master master;
    private List<Post> posts;
    private String html;
    private AlertDialog alertDialog;
    private boolean isLoadingMore = false;
    private String templete;

    private LinearLayout layout_ads;
    private IFLYBannerAd bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqd_web);
        ButterKnife.bind(this);
        init();
        getData();
        initjs();
        createBannerAd();

    }

    public void createBannerAd() {
        //此广告位为Demo专用，广告的展示不产生费用
        String adUnitId = "3E233A721FCE8A1EC09C3831CC2EEDFB";
        //创建旗帜广告，传入广告位ID
        bannerView = IFLYBannerAd.createBannerAd(this, adUnitId);
        //设置请求的广告尺寸
        bannerView.setAdSize(IFLYAdSize.BANNER);
        //设置下载广告前，弹窗提示
        bannerView.setParameter(AdKeys.DOWNLOAD_ALERT, "true");

        //请求广告，添加监听器
        bannerView.loadAd(mAdListener);
        //将广告添加到布局
        layout_ads = (LinearLayout) findViewById(R.id.layout_adview);
        layout_ads.removeAllViews();
        layout_ads.addView(bannerView);

    }

    @SuppressLint("JavascriptInterface")
    private void initjs() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void prev() {
                if (page == 1) {
                    Snackbar.make(webView, "已经到顶了", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                page -= 1;
                getData();
            }

            @JavascriptInterface
            public void next() {
                if (page < totolepage) {
                    page += 1;
                    getData();
                    return;
                }
                Snackbar.make(webView, "已经到底了", Snackbar.LENGTH_SHORT).show();
            }

            @JavascriptInterface
            public void jump(String pagej) {
                try {
                    int pageNum = Integer.parseInt(pagej);
                    if (pageNum <= 0 || pageNum > totolepage) {
                        Snackbar.make(webView, "请填写正确的页码哦", Snackbar.LENGTH_SHORT).show();
                        return;
                    }
                    page = Integer.valueOf(pagej);
                    getData();

                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(webView, "页码页面参数错误", Snackbar.LENGTH_SHORT).show();
                }
            }

            @JavascriptInterface
            public void sendmsg(String user) {
                Snackbar.make(webView, "暂不支持~", Snackbar.LENGTH_SHORT).show();
            }

            @JavascriptInterface
            public void reply(String user) {
                Snackbar.make(webView, "暂不支持~", Snackbar.LENGTH_SHORT).show();
            }

            @JavascriptInterface
            public void userinfo(String uid) {
                Snackbar.make(webView, "暂不支持~", Snackbar.LENGTH_SHORT).show();
            }


        }, "demo");
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        master = new Master();
        posts = new ArrayList<>();
        topic_id = getIntent().getStringExtra("topic_id");
        board_id = getIntent().getStringExtra("board_id");
        getSupportActionBar().setTitle(getIntent().getStringExtra("title") + "");
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        detailService = retrofit.create(DetailService.class);

        templete = readTemplate();
    }

    private void getData() {
        alertDialog = new AlertDialog.Builder(QqdWebActivity.this)
                .setCancelable(false)
                .setView(R.layout.progress_layout)
                .create();
        alertDialog.show();
        LogUtil.error(QqdWebActivity.class, "当前第" + page);
        detailService.getDetails(topic_id, board_id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Detail>() {
                    @Override
                    public void call(Detail detail) {
                        master = detail.getHtml().getMaster();
                        totolepage = detail.getPageTotal();
                        posts = detail.getHtml().getPosts();
                        html = makeHtml(readTemplate(), master, posts);
//                        webView.loadDataWithBaseURL(null,html.replace("{{font-size}}", "1.3"), "text/html", "utf-8", null);
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                LogUtil.error(QqdWebActivity.class, html.substring(0, 20) + "这是新内容");
                                webView.loadUrl("file://" + storeHtml(html.replace("{{font-size}}", "1.3")));
                                webView.scrollTo(0, 0);
//                                webView.loadDataWithBaseURL(null,html.replace("{{font-size}}", "1.3"), "text/html", "utf-8", null);
                            }
                        });

                        alertDialog.dismiss();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.error(QqdWebActivity.class, throwable.getMessage() + "这是出错咯");
                        alertDialog.dismiss();
                    }
                });


    }

    private String readTemplate() {
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = getAssets().open("topic_template_new.html");
            byte[] buffer = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            while (true) {
                int length = is.read(buffer);
                if (length != -1) {
                    sb.append(new String(buffer, 0, length));
                } else {
                    is.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String makeHtml(String htmlTemplate, Master master, List<Post> posts) {
        String res = htmlTemplate.replace("{{master.title}}", master.getTitle() + "")
                .replace("{{master.master}}", master.getMaster() + "")
                .replace("{{master.state}}", master.getState() + "")
                .replace("{{master.create_at}}", master.getCreateAt() + "")
                .replace("{{master.uid}}", master.getUid() + "")
                .replace("{{master.main}}", master.getMain() + "")
                .replace("{{master.face}}", master.getFace() + "")
                .replace("{{page}}", page + "")
                .replace("{{page_total}}", totolepage + "");
        StringBuffer sbPosts = new StringBuffer();
        if (posts != null) {
            for (Post value : posts) {
                sbPosts.append(("<div class=\"p_box\"><div class=\"s_tit\"><span class=\"ico_msg\" onclick=\"javascript:sendmsg('{{post.author}}')\">\u7eb8\u6761</span> " +
                        "<span class=\"ico_post\" onclick=\"javascript:reply('{{post.author}}')\">\u56de\u590d</span>{{post.floor}}\u697c <span class=\"cGreen\" onclick=\"javascript:userinfo('{{post.uid}}')\">" +
                        "{{post.author}}</span></div><div class=\"s_con\">{{post.content}}</div><p class=\"s_date\">{{post.create_at}}</p></div>").replace("{{post.floor}}", value.getFloor() + "")
                        .replace("{{post.author}}", value.getAuthor())
                        .replace("{{post.create_at}}", value.getCreateAt()).replace("{{post.uid}}",
                                value.getUid()).replace("{{post.content}}", value.getContent()));
            }
        }
        return res.replace("{{html.posts}}", sbPosts.toString());
    }

    private String storeHtml(String html) {
        byte[] data = html.getBytes();
        try {
            FileOutputStream outStream = openFileOutput("club_detial.html", 0);
            outStream.write(data);
            outStream.flush();
            outStream.close();
            LogUtil.error(QqdWebActivity.class, getFilesDir() + File.separator + "club_detial.html");
            return getFilesDir() + File.separator + "club_detial.html";
        } catch (Exception e) {
            LogUtil.error(QqdWebActivity.class, "错误" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    IFLYAdListener mAdListener = new IFLYAdListener() {

        /**
         * 广告请求成功
         */
        @Override
        public void onAdReceive() {
            //展示广告
            bannerView.showAd();

            Log.d("Ad_Android_Demo", "onAdReceive");
        }

        /**
         * 广告请求失败
         */
        @Override
        public void onAdFailed(AdError error) {
            Log.d("Ad_Android_Demo", "onAdFailed");
        }

        /**
         * 广告被点击
         */
        @Override
        public void onAdClick() {
            Log.d("Ad_Android_Demo", "onAdClick");
        }

        /**
         * 广告被关闭
         */
        @Override
        public void onAdClose() {
            Log.d("Ad_Android_Demo", "onAdClose");
        }

        @Override
        public void onAdExposure() {
            // TODO Auto-generated method stub

        }
    };
}

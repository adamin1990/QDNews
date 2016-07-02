package adamin90.com.qqd;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import timber.log.Timber;

/**
 * Created by LiTao on 2015-11-29-20:49.
 * Company: QD24so
 * Email: 14846869@qq.com
 * WebSite: http://lixiaopeng.top
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        MultiDex.install(getApplicationContext());

    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);

    }
}

package adamin90.com.qqd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import adamin90.com.qqd.moled.code.CodeModel;
import adamin90.com.qqd.service.Code;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private Code code;

    @Bind(R.id.fab) FloatingActionButton floatingActionButton;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        retrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String timesa=String.valueOf(System.currentTimeMillis());

        String nonce=String.valueOf((new Random().nextInt(1369999999) % 1) + 1360000000);
        String[] arr = new String[]{"QDNEWS_CLUB_POST_TOKEN", timesa, nonce};
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        String shaStr = EncryptionUtil.SHA1(arr[0] + arr[1] + arr[2]);


        final Date date=new Date();

        code=retrofit.create(Code.class);
        code.restMobile("15725266027",timesa,shaStr,"sendsms"
        ,nonce).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CodeModel>() {
                    @Override
                    public void call(CodeModel codeModel) {
                       Snackbar.make(toolbar,codeModel.getResult()+codeModel.getInfo()+codeModel.getUid()+"解雇哦"+date.getTime()+"",Snackbar.LENGTH_INDEFINITE).show();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Snackbar.make(toolbar,"错误"+throwable.toString(),Snackbar.LENGTH_INDEFINITE).show();
                    }
                });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

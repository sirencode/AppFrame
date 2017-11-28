package com.syh.diablo.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.syh.diablo.appframe.net.ApiFactory;
import com.syh.diablo.appframe.net.HomeApi;
import com.syh.diablo.appframe.net.MarginRatioData;
import com.syh.diablo.appframe.net.MySubscriber;
import com.syh.diablo.appframe.net.ServerType;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView info;
    private MySubscriber mySubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.netInfo);
        findViewById(R.id.getInfoBtn).setOnClickListener(this);
    }

    private void getData() {
        if (mySubscriber != null) {
            mySubscriber.dispose();
        }
        mySubscriber = new MySubscriber<MarginRatioData>(this, false) {
            @Override
            protected void onSuccess(MarginRatioData marginRatioData) {
                Log.d("success", String.valueOf(marginRatioData.getData().getInstrumentName()));
                info.setText(marginRatioData.getData().getInstrumentName());
            }

            @Override
            protected void onFail(Throwable e) {
                Log.d("onFail", e.getMessage());
            }
        };

        ApiFactory.getInstance().create(ServerType.HOME, HomeApi.class)
                .getMarginRatio("ag1712", "REALITY").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mySubscriber);
    }

    @Override
    public void onClick(View view) {
        getData();
    }
}

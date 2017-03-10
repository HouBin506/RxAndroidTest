package com.herenit.rxandroidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.herenit.rxandroidtest.android_rx.RxUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createObservable1(View view) {
        RxUtils.createObservable1();
    }

    public void createObservable2(View view) {
        RxUtils.createObservable2();
    }

    public void from(View view) {
        RxUtils.from();
    }

    public void interval(View view) {
        RxUtils.interval();
    }

    public void just(View view) {
        RxUtils.just();
    }

    public void range(View view) {
        RxUtils.range();
    }

    public void filter(View view) {
        RxUtils.filter();
    }

    public void intoDownload(View view) {
        startActivity(new Intent(MainActivity.this,DownloadActivity.class));
    }
    public void intoLogin(View view) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}

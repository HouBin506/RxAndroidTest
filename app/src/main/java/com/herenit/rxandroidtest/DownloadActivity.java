package com.herenit.rxandroidtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.herenit.rxandroidtest.utils.DownloadUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DownloadActivity extends Activity {

    private static final String TAG = DownloadActivity.class.getSimpleName();

    private ImageView mImg;
    private Button mBtn;
    private String url = "http://i.meizitu.net/2013/08/21054WR6-5.jpg";

    private DownloadUtil mUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        mImg = (ImageView) findViewById(R.id.imageView);
        mBtn = (Button) findViewById(R.id.button8);
        mUtil = new DownloadUtil();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUtil.downloadImage(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        mImg.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }
}

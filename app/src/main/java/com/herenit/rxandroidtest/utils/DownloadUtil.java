package com.herenit.rxandroidtest.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by HouBin on 2017/2/23.
 */

public class DownloadUtil {
    private OkHttpClient mClient;

    public DownloadUtil() {
        mClient = new OkHttpClient();
    }

    /**
     * 声明一个被观察者对象，作为结果返回
     * @param url
     * @return
     */
    public Observable<byte[]> downloadImage(final String url) {
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    final Request request = new Request.Builder().url(url).build();
                    mClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            subscriber.onError(e);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()) {
                                byte[] bytes = response.body().bytes();
                                if (bytes != null) {
                                    subscriber.onNext(bytes);
                                }
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }
}

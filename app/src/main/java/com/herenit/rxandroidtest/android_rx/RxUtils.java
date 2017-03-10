package com.herenit.rxandroidtest.android_rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by HouBin on 2017/2/23.
 */

public class RxUtils {
    private static final String TAG = RxUtils.class.getSimpleName();//使用类名作为Tag

    /**
     * 使用create方法实现
     */
    public static void createObservable1() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {//如果订阅者并未解除关联
                    subscriber.onNext("Hello!!");
                    subscriber.onNext("World!!");
                    subscriber.onNext(download());
                    subscriber.onCompleted();
                }
            }
        });
        Subscriber<String> showSub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, s);
            }
        };
        observable.subscribe(showSub);//关联被观察者
    }

    public static String download() {
        return "result data";
    }

    /**
     * 使用creat方法2
     */
    public static void createObservable2() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int x = 1; x < 10; x++) {
                        subscriber.onNext(x);
                    }
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "result-->" + integer);
            }
        });
    }

    /**
     * from方法，一般适用于被观察者返回的是数值类型的数据
     */
    public static void from() {
        Integer[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Observable observable = Observable.from(items);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * interval方法
     * 每隔规定时间，像观察者发送一次数据
     */
    public static void interval() {
        Integer[] items = {1, 2, 3, 4, 5, 6};
        Observable observable = Observable.interval(1, 1, TimeUnit.SECONDS);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * just方法
     */
    public static void just() {
        Integer[] items1 = {1, 2, 3, 4, 5, 6};
        Integer[] items2 = {10, 20, 30, 40, 50, 60};
        Observable observable = Observable.just(items1, items2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Integer[] o) {
                for (int x = 0; x < o.length; x++) {
                    Log.i(TAG,o[x]+"");
                }
            }
        });
    }

    /**
     * 指定依次返回某一范围的数据
     */
    public static void range(){
        Observable observable = Observable.range(1,40);
        observable.subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * 根据筛选条件返回数值
     */
    public static void filter(){
      Observable observable = Observable.just(1,23,3,4,8,6,7,55,6,12);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o<=6;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                Log.i(TAG, o.toString());
            }
        });

    }

}

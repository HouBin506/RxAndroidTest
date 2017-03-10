package com.herenit.rxandroidtest.java_rx2;

import java.util.Observable;

/**
 * Created by HouBin on 2017/2/23.
 */

public class Test2 {

    public static void main(String[] args) throws Exception{
        SimpleObservable observable = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver(observable);
        observable.setData(1);
        observable.setData(2);
        observable.setData(2);
        observable.setData(3);
        observable.setData(4);

    }
}

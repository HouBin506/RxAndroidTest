package com.herenit.rxandroidtest.java_rx2;

import java.util.Observable;

/**
 * Created by HouBin on 2017/2/23.
 * 创建被观察着类
 */

public class SimpleObservable extends Observable {
    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if(this.data != data){
            this.data = data;
            setChanged();//设置被观察者数据改变
            notifyObservers();//通知观察者数据发生了改变
        }
    }
}

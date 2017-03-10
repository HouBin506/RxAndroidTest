package com.herenit.rxandroidtest.java_rx2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by HouBin on 2017/2/23.
 * 创建观察者类
 */

public class SimpleObserver implements Observer {

    public SimpleObserver(Observable observable){
        observable.addObserver(this);//给观察者添加被观察的对象
    }

    //被观察者的状态发生改变，发出通知时候，就会调用此方法
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Data is changed:"+((SimpleObservable)o).getData()+"--");
    }
}

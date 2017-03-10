package com.herenit.rxandroidtest.java_rx;

/**
 * Created by HouBin on 2017/2/23.
 */

public class ConcreteWatcher  implements Watcher{
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}

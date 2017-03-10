package com.herenit.rxandroidtest.java_rx;

/**
 * Created by HouBin on 2017/2/23.
 */

public class Test {

    public static void main(String[] args) throws Exception {
        Watched watched = new ConcreteWatched();
        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();
        watched.addWatcher(watcher1);
        watched.addWatcher(watcher2);
        watched.addWatcher(watcher3);

        watched.notifyWatchers("我要偷东西啦！！！");
    }
}

package com.herenit.rxandroidtest.java_rx;

/**
 * Created by HouBin on 2017/2/23.
 */

public interface Watched {
    void addWatcher(Watcher watcher);
    void removeWatcher(Watcher watcher);
    void notifyWatchers(String str);
}

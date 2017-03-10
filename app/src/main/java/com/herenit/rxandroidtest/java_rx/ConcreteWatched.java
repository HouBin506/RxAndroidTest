package com.herenit.rxandroidtest.java_rx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HouBin on 2017/2/23.
 */

public class ConcreteWatched  implements Watched{
    private List<Watcher> watchers = new ArrayList<>();
    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for(Watcher watcher:watchers){
            watcher.update(str);
        }
    }
}

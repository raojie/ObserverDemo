package com.raoj.observer;

import com.raoj.observer.listener.ObserverListener;
import com.raoj.observer.listener.SubjectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoj on 2017/6/5.
 * 观察者管理类
 */

public class ObserverManager implements SubjectListener {

    private static ObserverManager observerManager;
    //观察者接口集合
    private List<ObserverListener> list = new ArrayList<>();

    /**
     * 单例
     */
    public static ObserverManager getInstance() {
        if (observerManager == null) {
            synchronized (ObserverManager.class) {
                if (observerManager == null) {
                    observerManager = new ObserverManager();
                }
            }
        }
        return observerManager;
    }

    /**
     * 加入监听队列
     */
    @Override
    public void add(ObserverListener observerListener) {
        list.add(observerListener);
    }

    /**
     * 通知观察者刷新数据
     */
    @Override
    public void notifyObserver(String content) {
        for (ObserverListener observerListener : list) {
            observerListener.observerUpData(content);
        }
    }

    /**
     * 监听队列中移除
     */
    @Override
    public void remove(ObserverListener observerListener) {
        if (list.contains(observerListener)) {
            list.remove(observerListener);
        }
    }
}

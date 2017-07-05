package com.raoj.observer.listener;

/**
 * Created by raoj on 2017/6/5.
 * 被观察者接口
 */

public interface SubjectListener {
    void add(ObserverListener observerListener);

    void notifyObserver(String content);

    void remove(ObserverListener observerListener);
}

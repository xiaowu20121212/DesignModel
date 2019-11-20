package com.company.observable;

import java.util.ArrayList;

/**
 * 可订阅者
 *
 * @param <T>
 */
public abstract class Observable<T extends IObserver> {
    //观察者，用于观察可订阅者
    protected final ArrayList<T> mObservers = new ArrayList<>();

    public void registerObserver(T observer) {
        if (observer == null) {
            return;
        }
        synchronized (mObservers) {
            if (!mObservers.contains(observer)) {
                mObservers.add(observer);
            }
        }
    }

    public void unregisterObserver(T observer) {
        if (observer == null) {
            return;
        }
        synchronized (mObservers) {
            if (mObservers.contains(observer)) {
                mObservers.remove(observer);
            }
        }
    }

    public void unregisterAll() {
        synchronized (mObservers) {
            mObservers.clear();
        }
    }


    public void notifyChanged() {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onChange();
            }
        }
    }
}

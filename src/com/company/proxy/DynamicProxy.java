package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public abstract class DynamicProxy<T>  {
    public T newProxyInstance(T t) {
        ClassLoader classLoader = t.getClass().getClassLoader();
        InvocationHandler handler = createHandler(t);
        return (T) Proxy.newProxyInstance(classLoader, t.getClass().getInterfaces(), handler);
    }

    protected abstract InvocationHandler createHandler(T t);
}

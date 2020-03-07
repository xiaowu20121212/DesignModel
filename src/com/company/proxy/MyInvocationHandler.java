package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName() + "方法调用前");
        return method.invoke(target, objects);
    }
}

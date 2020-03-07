package com.company.proxy;

import java.lang.reflect.InvocationHandler;

public class SubjectDynamicProxy extends DynamicProxy<Subject>{
    @Override
    protected InvocationHandler createHandler(Subject subject) {
        return new MyInvocationHandler(subject);
    }
}

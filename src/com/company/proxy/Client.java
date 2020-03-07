package com.company.proxy;

public class Client {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Subject proxy = new SubjectDynamicProxy().newProxyInstance(subject);
        proxy.doSomething("do something");

    }
}

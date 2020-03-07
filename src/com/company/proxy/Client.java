package com.company.proxy;

public class Client {
    public static void main(String[] args) {
        Subject proxy = new SubjectDynamicProxy().newProxyInstance(new RealSubject());
        proxy.doSomething("do something");
        proxy.run();
        proxy.eat();

    }
}

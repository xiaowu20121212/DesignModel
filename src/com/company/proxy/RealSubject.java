package com.company.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.printf("RealSubject doSomething---------------------");
    }
}

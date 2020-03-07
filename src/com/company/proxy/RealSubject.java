package com.company.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String str) {
        System.out.println("RealSubject doSomething---------------------");
    }

    @Override
    public void eat() {
        System.out.println("RealSubject eat---------------------");
    }

    @Override
    public void run() {
        System.out.println("RealSubject run---------------------");
    }
}

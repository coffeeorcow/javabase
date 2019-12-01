package com.yi.pattern.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String something) {
        System.out.println(something);
    }
}

package com.yi.functional;

@FunctionalInterface
public interface Consumer {
    void consume();

    default void consume1() {
        System.out.println("这是默认消费方法1");
    }
}

package com.yi.pattern.factory;

public interface Human {
    default void getColor() {
        System.out.println("unknown");
    }

    default void talk() {
        System.out.println("can't talk");
    }
}

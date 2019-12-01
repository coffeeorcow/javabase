package com.yi.pattern.factory;

public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("black skin.");
    }

    @Override
    public void talk() {
        System.out.println("bla,bla,bla...");
    }
}

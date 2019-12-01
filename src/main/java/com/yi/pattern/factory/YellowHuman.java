package com.yi.pattern.factory;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("yellow skin.");
    }

    @Override
    public void talk() {
        System.out.println("汉语。");
    }
}

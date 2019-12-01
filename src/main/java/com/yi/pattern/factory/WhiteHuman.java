package com.yi.pattern.factory;

public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("white skin.");
    }

    @Override
    public void talk() {
        System.out.println("speak English...");
    }
}

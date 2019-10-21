package com.yi.functional;

public class Client {

    public void consume(Consumer consumer) {
        System.out.println("Client start consume... ");
        consumer.consume();
    }

}

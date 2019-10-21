package com.yi.functional;

public class ClientTest {

    public static void main(String[] args) {
        Client client = new Client();
        client.consume(() -> System.out.println("consumign.. "));
    }

}

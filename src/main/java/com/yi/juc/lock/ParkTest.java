package com.yi.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ParkTest {

    public static void main2(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("start park");
            LockSupport.park();
            System.out.println("end park");
        });
        thread1.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("main unpark thread1 ");
        LockSupport.unpark(thread1);
    }

    public static void main1(String[] args) {
        System.out.println("begin park");
        LockSupport.park(new ParkTest());
        System.out.println("end park");
    }

}

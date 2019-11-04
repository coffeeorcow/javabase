package com.yi.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private void waitTest() {
        lock.lock();
        try {
            System.out.println("begin wait");
            condition.await();
            System.out.println("end wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signalTest() {
        lock.lock();
        try {
            Thread.sleep(3000);
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();

        Thread thread1 = new Thread(() -> {
            test.waitTest();
        });

        Thread thread2 = new Thread(() -> {
            test.signalTest();
        });

        thread1.start();
        thread2.start();
    }

}

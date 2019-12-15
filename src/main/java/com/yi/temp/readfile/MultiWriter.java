package com.yi.temp.readfile;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 多个线程同时写入数据
 */
public class MultiWriter {

    private static String filePath = "D:\\temp\\temp.txt";

    private static final class WriterThread implements Runnable {

        @Override
        public void run() {
            try (OutputStream os = new FileOutputStream(new File(filePath), true)) {
                for (int i = 10; i > 0; i--) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "开始写入");
                    os.write(("number: " + i + "\n").getBytes());
                }
                os.flush();
            } catch (FileNotFoundException e) {
                System.out.println("文件找不到");
            } catch (IOException e) {
                System.out.println("文件读取失败");
            } catch (InterruptedException e) {
                System.out.println("线程中断异常");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("开始写入");
        WriterThread writer = new WriterThread();
        for (int i = 10; i > 0; i--) {
            new Thread(writer).start();
            System.out.println("新建成功");
        }
    }

}

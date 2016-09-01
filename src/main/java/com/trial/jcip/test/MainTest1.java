package com.trial.jcip.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by li on 2016/2/3.
 */
public class MainTest1 implements Runnable{
    private final static AtomicLong count = new AtomicLong(0);
//    private  static int count = 0;
    private  int id = 0;
    private Random random = new Random(47);

    private  void pause(){
        try {
            Thread.sleep(100 +  random.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void create(){
//        ++count;
        count.incrementAndGet();
        System.out.println(count);
    }
    private final Date date = new Date();
    final String[] strings = new String[3];


    public static void main(String[] args) {
       final MainTest1 test = new MainTest1();
        test.date.setDate(new Date().getDate());
        test.strings[1] = "Hello";
//        System.out.println();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
               exec.execute(new MainTest1());
        }
////        test.pause();
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           pause();
           create();
       }
    }
}

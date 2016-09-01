package com.trial.thread;

/**
 * Created by li on 2016/4/24.
 */
public class T1 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
//            private final int id;
            @Override
            public void run() {
                System.out.println("r1:\t"+Thread.currentThread().getId()+"\t"+Thread.currentThread());
            }
        };
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t:\t"+Thread.currentThread().getId()+"\t"+Thread.currentThread());
            }
        });

        r1.run();
        t.start();
        System.out.println(Thread.currentThread());
    }
}

package com.trial.thread;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by li on 2016/4/24.
 */
class T {

    public static boolean asleep = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    judge();
                }
            }).start();
        }
        Thread.sleep(500);

        Vector vector;
        new Thread(new Runnable() {
            public void run() {
                asleep = true;
                System.out.println("end");
            }
        }).start();

    }

    public static void judge() {
        while (!asleep) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CMS();
        }
    }

    public static void CMS() {
        System.out.println(Thread.currentThread() + "@");
    }

}
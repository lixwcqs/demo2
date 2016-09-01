package com.trial.jcip.test;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by li on 2016/5/7.
 */
public class VectorTest {
    public static Object getLast(Vector vector) {
        int i = vector.size() - 1;
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("remove and sleep over\t" + vector.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vector.get(i);
    }

    public static void removeLast(Vector vector) {
        int i = vector.size() - 1;
        vector.remove(i);

    }

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        Thread t1 = new Thread(new ThreadVector2(vector));
        Thread t2 = new Thread(new ThreadVector3(vector));
        t2.start();
        System.out.println("t1.start " + vector.size());
        TimeUnit.SECONDS.sleep(1);
        t1.start();
        System.out.println(vector.size());

    }

}


class ThreadVector2 implements Runnable {

    private Vector test;
    public ThreadVector2(Vector test) {
        this.test = test;
    }

    @Override
    public void run() {
        VectorTest.removeLast(test);
    }
}

class ThreadVector3 implements Runnable {

    private Vector test;

    public ThreadVector3(Vector test) {
        this.test = test;
    }

    @Override
    public void run() {
        VectorTest.getLast(test);
    }
}


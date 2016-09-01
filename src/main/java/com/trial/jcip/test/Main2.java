package com.trial.jcip.test;

import com.trial.ThreadUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by li on 2016/2/3.
 */
public class Main2 implements Runnable {
    private final Set<String> stringSet = new HashSet<>();
    private final int id;
    private Main4 main4;

    private static Lock lock = new ReentrantLock();


    public Main2(int id) {
        stringSet.add("Hello");
        this.id = id ;
    }

    public void setMain4(Main4 main4) {
        stringSet.add("World");
        this.main4 = main4;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                ThreadUtils.pause(200,200);
                main4.add("Thread " + id);
                System.out.println("Thread " + id + "\t" + main4.getCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Main4 main4 = new Main4(0);
        for (int i = 0; i < 1; i++) {
            Main2 main2 = new Main2(i);
            main2.setMain4(main4);
            exec.execute(main2);
        }
        ThreadUtils.pause(1000, 1);
        exec.shutdownNow();
        Main3 main3 = new Main3(4);
        main3.count = 3;
    }
}

class  Main4{
    private final  int id ;

    private  int count = 0;
    private static Lock lock = new ReentrantLock();

    Main4(int id) {
        this.id = id;
    }

    synchronized void add(String flag){
        System.out.println("============"+ flag +"==================");
        int tmp = 0;
        lock.lock();
        while (++tmp < 100){
             ++count;
        }
        try {
            throw new RuntimeException("exception");
        } catch (Exception e){

        }finally {
         ThreadUtils.pause(50,20);
            System.out.println(flag + " exception happens..");
        }
    }

    public int getCount() {
        return count;
    }
}
package com.trial.TIJ4.concurrency.restaurant2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by li on 2016/2/3.
 */
public class Chopstick {
    private final int id;//编号
    private boolean istaken;//是否被占用

    public Chopstick(int id) {
        this.id = id;
    }

    public synchronized void taken() {
        while (istaken) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + "is interrupted");
                e.printStackTrace();
            }
        }
        istaken = true;
    }

    public synchronized void drop() {
        istaken = false;
        notifyAll();
    }

    public void setIstaken(boolean istaken) {
        this.istaken = istaken;
    }

    public int getId() {
        return id;
    }
}

class Philosopher implements Runnable {
    private final int id;
    private Random random = new Random(47);

    private Chopstick[] chopsticks = new Chopstick[2];

    private void pause() {
        try {
            Thread.sleep(200 + random.nextInt(100));
//            Thread.sleep(random.nextInt(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void thinking() {
        for (int i = 0; i < 2; i++) {
            chopsticks[i].drop();
            System.out.println("Philosopher " + id + " drop chopstick " + chopsticks[i].getId());
        }
        System.out.println("Philosopher " + id + " drops all chopsticks...");
        pause();
        System.out.println("Philosopher " + id + " thinking over...");
    }

    public synchronized void eating() {
        System.out.println("Philosopher " + id + " wants to eat and need chopsticks...");
        for (int i = 0; i < 2; i++) {
            System.out.println("Philosopher " + id + " waiting chopstick " + chopsticks[i].getId());
            chopsticks[i].taken();
            System.out.println("Philosopher " + id + " has taken chopstick " + chopsticks[i].getId());
            pause();
        }
        System.out.println("Philosopher " + id + " start eating...");
        pause();
        System.out.println("Philosopher " + id + " has finished eating...");
    }

    public Philosopher(int id, Chopstick[] chopsticks) {
        this.id = id;
        this.chopsticks[1] = chopsticks[(id + 4) % 5];
        this.chopsticks[0] = chopsticks[id % 5];
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            thinking();
            eating();
        }
    }
}

class CPtest {
    public static void main(String[] args) throws InterruptedException {
        int cpSize = 5;
        Chopstick[] chopsticks = new Chopstick[cpSize];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Chopstick(i);
            chopsticks[i].setIstaken(false);
        }
        ExecutorService service = Executors.newCachedThreadPool();
        Philosopher[] philosophers = new Philosopher[cpSize];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, chopsticks);
            service.execute(philosophers[i]);
        }
//        TimeUnit.SECONDS.sleep(3);
//        service.shutdownNow();

    }
}



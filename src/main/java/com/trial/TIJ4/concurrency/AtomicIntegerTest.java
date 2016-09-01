package com.trial.TIJ4.concurrency;//: concurrency/AtomicIntegerTest.java
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class AtomicIntegerTest implements Runnable {
  private AtomicInteger i = new AtomicInteger(0);
  public int getValue() { return i.get(); }
  private void evenIncrement() {
    i.addAndGet(2);
  }
  public void run() {
    while(true){
      evenIncrement();
//      i.addAndGet(2);
      System.out.println(Thread.currentThread() + "\t" + i.get());
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  public static void main(String[] args) throws Exception {
    new Timer().schedule(new TimerTask() {
      public void run() {
        System.err.println("Aborting");
//        System.exit(0);
      }
    }, 1000); // Terminate after 5 seconds
    ExecutorService exec = Executors.newCachedThreadPool();
    AtomicIntegerTest ait = new AtomicIntegerTest();
    exec.execute(ait);
    while(true) {
      int val = ait.getValue();
      System.out.println(Thread.currentThread() + "val :" + val);
      Thread.sleep(500);
      if(val % 2 != 0) {
        System.out.println(val);
        System.exit(0);
      }
    }
  }
} ///:~

package com.trial.TIJ4.concurrency;//: concurrency/EvenChecker.java
import java.util.concurrent.*;

public class EvenChecker implements Runnable {
  private IntGenerator generator;
  private final int id;
  public EvenChecker(IntGenerator g, int ident) {
    generator = g;
    id = ident;
  }
  public void run() {
    while(!generator.isCanceled()) {
      int val = generator.next();
//      System.out.println("id: " + id + "\tthis: " + this + "\tgenerator: " + generator + "\tvalue: " + val);
      System.out.println("id: " + id + "\tvalue: " + val +"\t" + generator.isCanceled());
      if(val % 2 != 0) {
        System.out.println(val + " not even!");
        generator.cancel(); // Cancels all EvenCheckers
      }
      try {
        Thread.currentThread().sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  // Test any type of IntGenerator:
  public static void test(IntGenerator gp, int count) {
    System.out.println("Press Control-C to exit");
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < count; i++){
      exec.execute(new EvenChecker(gp, i));
    }
    exec.shutdown();
  }
  // Default value for count:
  public static void test(IntGenerator gp) {
    test(gp, 10);
  }
} ///:~

//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package com.trial.TIJ4.concurrency.waxomatic;
import java.util.concurrent.*;
import static net.mindview.util.Print.*;

class Car {
  //打蜡“开关”是否开启
  private boolean waxOn = false;
  //打蜡结束，准备【通知】抛光
  public synchronized void waxed() {
    System.out.println("waxed start...");
    waxOn = true; //开启打蜡
    notifyAll();
    System.out.println("waxed end...");
  }
  //抛光结束，准备【通知】打蜡
  public synchronized void buffed() {
    System.out.println("buffed start...");
    waxOn = false; //关闭打蜡，关闭打蜡后可开始抛光
    notifyAll();
    System.out.println("buffed over...");
  }
  public synchronized void waitForWaxing() throws InterruptedException {
    System.out.println("waitForWaxing start...");
    while(waxOn == false)//若打蜡控制开关关闭，则一直等待
      wait();
    System.out.println("waitForWaxing end...");
  }
  public synchronized void waitForBuffing() throws InterruptedException {
    System.out.println("waitForBuffing start...");
    while(waxOn == true) {//若打蜡控制开关打开，则一直等待
      wait();
      System.out.println("waitForBuffing end...");
    }
  }
}

class WaxOn implements Runnable {
  private Car car;
  public WaxOn(Car c) { car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        printnb("Wax On! ");
        TimeUnit.MILLISECONDS.sleep(200);
        car.waxed();//打蜡
        car.waitForBuffing();//通知抛光
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax On task");
  }
}

class WaxOff implements Runnable {
  private Car car;
  public WaxOff(Car c) { car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        car.waitForWaxing();
        printnb("Wax Off! ");
        TimeUnit.MILLISECONDS.sleep(200);
        car.buffed();
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax Off task");
  }
}

public class WaxOMatic {
  public static void main(String[] args) throws Exception {
    Car car = new Car();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new WaxOff(car));
    exec.execute(new WaxOn(car));
    TimeUnit.SECONDS.sleep(1); // Run for a while...
    exec.shutdownNow(); // Interrupt all tasks
  }
} /* Output: (95% match)
Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt
Ending Wax On task
Exiting via interrupt
Ending Wax Off task
*///:~

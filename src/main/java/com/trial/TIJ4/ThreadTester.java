package com.trial.TIJ4;

import java.util.LinkedList;

class ThreadTesterA implements Runnable {
  
    private int counter;  
  
    @Override  
    public void run() {  
        while (counter <= 10) {  
            System.out.print("Counter = " + counter + " ");  
            counter++;  
        }
//        LinkedList
        System.out.println();  
    }  
}  
  
class ThreadTesterB implements Runnable {  
  
    private int i;  
  
    @Override  
    public void run() {  
        while (i <= 10) {  
            System.out.print("i = " + i + " ");  
            i++;  
        }  
        System.out.println();  
    }  
}  
  
public class ThreadTester {  
    public static void main(String[] args) throws InterruptedException {  
        Thread t1 = new Thread(new ThreadTesterA());  
        Thread t2 = new Thread(new ThreadTesterB());  
        t1.start();  
        t1.join(); //Main Thread wait t1 to be finished
        t2.start();  
        t2.join(); //
        System.out.println("Main Over");
    }  
}  
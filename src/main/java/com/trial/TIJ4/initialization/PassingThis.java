package com.trial.TIJ4.initialization;//: initialization/PassingThis.java

class Person {
  public void eat(Apple apple) {
    Apple peeled = apple.getPeeled();
    System.out.println("Yummy");
  }
}

class Peeler {
  static Apple peel(Apple apple) {
    // ... remove peel
    System.out.println(apple);
    return apple; // Peeled
  }
}

class Apple {
  Apple getPeeled() {
    System.out.println(this);
    return Peeler.peel(this); }
}

public class PassingThis {
  public static void main(String[] args) {
    Apple apple = new Apple();
    System.out.println(apple);
    new Person().eat(apple);
  }
} /* Output:
Yummy
*///:~

package com.trial.TIJ4.innerclasses;//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.
import static net.mindview.util.Print.*;

class Egg {
  private Yolk y;
  protected class Yolk {
    public Yolk() { print("Egg.Yolk()"); }
  }

    void  f(){
        System.out.println("Egg");
    }
  public Egg() {
    print("New Egg()");
    y = new Yolk();
      f();
  }
}	

public class BigEgg extends Egg {
  public class Yolk {
    public Yolk() { print("BigEgg.Yolk()"); }
  }
    void  f(){
        System.out.println("BigEgg");
    }
  public static void main(String[] args) {
    new BigEgg();
  }
} /* Output:
New Egg()
Egg.Yolk()
*///:~

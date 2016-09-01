package com.trial.TIJ4.typeinfo;//: typeinfo/ClassCasts.java

class Building {}
class House extends Building {}

public class ClassCasts {
  public static void main(String[] args) {
    Building b = new House();
      System.out.println(b.getClass() +"\t" + (b instanceof House) + "\t" + (b instanceof Building));

    Class<House> houseType = House.class;
    House h = houseType.cast(b);
    h = (House)b; // ... or just do this.
  }
} ///:~

package com.trial.TIJ4.typeinfo;//: typeinfo/WildcardClassReferences.java

public class WildcardClassReferences {
  public static void main(String[] args) {
    Class<?> intClass = int.class;
    intClass = double.class;
    intClass = WildcardClassReferences.class;
  }
} ///:~

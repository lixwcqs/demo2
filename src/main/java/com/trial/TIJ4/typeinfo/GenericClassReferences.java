package com.trial.TIJ4.typeinfo;//: typeinfo/GenericClassReferences.java

public class GenericClassReferences {
  public static void main(String[] args) {
    Class intClass = int.class;
    Class<Integer> genericIntClass = int.class;
    Class<Number> genericIntClass2 = intClass;
      System.out.println(genericIntClass);
    genericIntClass = Integer.class; // Same thing
      System.out.println(genericIntClass.getSuperclass() + "\t" + genericIntClass.getClassLoader());
      intClass = double.class;
    // genericIntClass = double.class; // Illegal
  }
} ///:~

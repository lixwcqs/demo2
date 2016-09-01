package com.trial.TIJ4.typeinfo.toys;

public class GenericToyTest {
  public static void main(String[] args) throws Exception {
    Class<FancyToy> ftClass = FancyToy.class;
    Class<? extends Toy> ftClass2 = FancyToy.class;
    // Produces exact type:
    Toy fancyToy = ftClass.newInstance();
    Class<? super FancyToy> up = ftClass.getSuperclass();
      System.out.println(up.getCanonicalName());
    // This won't compile:
//     Class<Toy> up2 = ftClass.getSuperclass();
    // Only produces Object:
    Object obj = up.newInstance();
//      Toy obj2 = up.newInstance();
  }
} ///:~

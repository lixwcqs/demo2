//: typeinfo/pets/ForNameCreator.java
package com.trial.TIJ4.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.trial.TIJ4.typeinfo.pets.Mutt",
    "com.trial.TIJ4.typeinfo.pets.Pug",
    "com.trial.TIJ4.typeinfo.pets.EgyptianMau",
    "com.trial.TIJ4.typeinfo.pets.Manx",
    "com.trial.TIJ4.typeinfo.pets.Cymric",
    "com.trial.TIJ4.typeinfo.pets.Rat",
    "com.trial.TIJ4.typeinfo.pets.Mouse",
    "com.trial.TIJ4.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~

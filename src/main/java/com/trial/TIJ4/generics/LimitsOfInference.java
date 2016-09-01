package com.trial.TIJ4.generics;//: generics/LimitsOfInference.java

import com.trial.TIJ4.typeinfo.pets.Person;
import com.trial.TIJ4.typeinfo.pets.Pet;
import net.mindview.util.New;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
  static void f(Map<Person, List<? extends Pet>> petPeople) {}
  public static void main(String[] args) {
     f(New.map()); // Does not compile
  }
} ///:~

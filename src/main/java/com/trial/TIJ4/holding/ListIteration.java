package com.trial.TIJ4.holding;//: holding/ListIteration.java

import com.trial.TIJ4.typeinfo.pets.Pet;
import com.trial.TIJ4.typeinfo.pets.Pets;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
  public static void main(String[] args) {
    List<Pet> pets = Pets.arrayList(8);
    System.out.println("pets: " + pets);
    ListIterator<Pet> it = pets.listIterator();
//      System.out.println(it.hasPrevious() +"\t" + it.previousIndex() + "\t" + it.nextIndex());
    while(it.hasNext())
      System.out.print(it.next() + ", " + it.nextIndex() +
        ", " + it.previousIndex() + "; ");
    System.out.println();
    System.out.println(it.hasNext() + "\t" + it.nextIndex());
      // Backwards:
    while(it.hasPrevious())
      System.out.print(it.previous().id() + " ");
    System.out.println();
    System.out.println(pets);
    System.out.println("=======================");
    it = pets.listIterator(3);
    while(it.hasNext()) {
        System.out.print(it.next()+"\t");
      it.set(Pets.randomPet());
    }
    System.out.println();
    System.out.println(pets);
  }
} /* Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*///:~

package com.trial.TIJ4.generics;//: generics/ArrayMaker.java
import com.cqs.demo2.models.book.model.Book;

import java.lang.reflect.*;
import java.util.*;

public class ArrayMaker<T> {
  private Class<T> kind;
  public ArrayMaker(Class<T> kind) { this.kind = kind; }
  @SuppressWarnings("unchecked")
  T[] create(int size) {
    System.out.println(kind);
    Book[] boos = (Book[]) Array.newInstance(Book.class,5);
    System.out.println(boos.length+"\t" +boos[0]);
    return (T[])Array.newInstance(kind, size);
  }
  public static void main(String[] args) {
    ArrayMaker<String> stringMaker =
      new ArrayMaker<String>(String.class);
    String[] stringArray = stringMaker.create(9);
    System.out.println("index0: "+stringArray[0]);
    System.out.println(Arrays.toString(stringArray));
    try {
      System.out.println(String.class.newInstance().equals(""));
      System.out.println(Book.class.newInstance());
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
} /* Output:
[null, null, null, null, null, null, null, null, null]
*///:~

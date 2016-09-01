package com.trial.TIJ4.generics;//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)
//
//class Cat extends ComparablePet implements Comparable<Cat>{
//  // Error: Comparable cannot be inherited with
//  // different arguments: <Cat> and <Pet>
//  public int compareTo(Cat arg) { return 0; }
//} ///:~

class Cat {
    // Error: Comparable cannot be inherited with
    // different arguments: <Cat> and <Pet>
    public int compareTo(Cat arg) { return 0; }
} ///:~

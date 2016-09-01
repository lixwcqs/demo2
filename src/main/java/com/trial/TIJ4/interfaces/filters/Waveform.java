//: interfaces/filters/Waveform.java
package com.trial.TIJ4.interfaces.filters;

public class Waveform {
  private static long counter;
  private final long id = counter++;
  public String toString() { return "Waveform " + id; }
} ///:~

package com.trial.TIJ4.generics;//: generics/UseList.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class UseList<W,T> {

  void f(List<T> v) {}
  // 注释这里，方法签名重复
//  void f(List<W> v) {}
} ///:~

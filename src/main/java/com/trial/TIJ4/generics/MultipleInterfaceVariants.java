package com.trial.TIJ4.generics;//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)  需要 注释class Employee的声明

interface Payable<T> {}

//class Employee implements Payable<Employee> {}
class Hourly extends Employee   implements Payable<Hourly> {} ///:~

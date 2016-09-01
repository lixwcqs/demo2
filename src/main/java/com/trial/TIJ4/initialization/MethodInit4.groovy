package com.trial.TIJ4.initialization

/**
 * Created by li on 2016/1/19.
 */
class MethodInit4 {
    //! int j = g(i); // Illegal forward reference
    int i = f();

    public MethodInit4() {
        System.out.println("i = " + i);
    }

    int f() {
        System.out.println("f()");
        return 11;
    }
    int g(int n) { return n * 10; }

    public static void main(String[] args) {
        MethodInit4 init4 = new MethodInit4();
    }
}

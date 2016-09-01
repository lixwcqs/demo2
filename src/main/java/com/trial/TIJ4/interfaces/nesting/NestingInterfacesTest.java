package com.trial.TIJ4.interfaces.nesting;

/**
 * Created by li on 2016/2/7.
 */
public class NestingInterfacesTest {
    class Main9 {
        public void f(){
            System.out.println("f()...");
        }
    }

    public Main9 getMain9Instance(){
        return new Main9();
    }

    public static void main(String[] args) {
       NestingInterfacesTest test = new NestingInterfacesTest();
        Main9 m9 = test.getMain9Instance();
//        m9 = new Main9();
    }
}

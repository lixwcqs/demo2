package com.trial.others;

import com.cqs.demo2.models.book.model.Book;
import com.trial.ThreadUtils;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by li on 2016/3/25.
 */
public class T2 {

    private String s ;
    private String s1 ="2" ;

    private int a ;
    private int a1= 200000 ;

    private static boolean  b ;
    private static boolean  b1 = true;



    private Book book;
    private Book book1 = new Book();
    private static Book book2;
    private static Book book3 = new Book();


    void useManyNumeric() {
        int i = 100;
        int j = 1000000;
        long l1 = 1;
        long l2 = 0xffffffff;
        double d = 2.2;

        this.s = "Hello World";
    }

    void f1(){}

    void f2(String s){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sh0[] sh0s = new Sh0[1024 * 2];
        Bi1[] bi1s = new Bi1[1024 * 2];
//        Bi1[] bi1s2 = new Bi1[1024 * 3];
//        Bi1[] bi1s3 = new Bi1[1024];
        for (int i = 1; i < bi1s.length ; i++) {
            String s3 = String.valueOf(i);
            bi1s[i] = new Bi1();
            sh0s[i] = new Sh0();
        }
        Bi0 bio = new Bi0();
        Bi1 bi1 = new Bi1();
        Bi2 bi2 = new Bi2();
        Bi3 bi3 = new Bi3();
        Bi4 bi4 = new Bi4();
        System.out.println("-----------------------");
        Book book;
        for (int i = 0; i < 1000; i++) {
            book = new Book();
        }
        System.out.println("-----------------------");
        try {
            TimeUnit.DAYS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    double f3(int a,int b){

        try {
            int c =  a/b;
            return c;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("被除数不能为0");
        }

    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.f3(5,1);
        t2.f2("one day");
    }
}

interface I1{

    void f1();
}

class T3{
    boolean f1(String s){
        return false;
    }
}


class Sh0{
    short[] shorts;
    public Sh0() {
    }
}

class Bi0{
    double[] doubles ;
    public Bi0() {
        doubles = new double[1024];
        for(int i = 0; i < doubles.length; ++i)
           doubles[i] = Math.random();
    }
}

class Bi1{
    double[] doubles ;
    public Bi1() {
//        doubles = new double[1024];
//        for(int i = 0; i < doubles.length; ++i)
//           doubles[i] = Math.random();
    }
}

class Bi2{
    double[] doubles ;
    public Bi2() {
        doubles = new double[1024*2];
//        for(int i = 0; i < doubles.length; ++i)
//           doubles[i] = Math.random();
    }
}


class Bi3{
    double[] doubles = new double[1024 * 3];

    public Bi3() {
        for(int i = 0; i < doubles.length; ++i)
           doubles[i] = Math.random();
    }
}


class Bi4{
    double[] doubles = new double[1024*5] ;
}
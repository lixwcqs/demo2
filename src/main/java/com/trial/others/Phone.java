package com.trial.others;

import com.cqs.demo2.models.book.model.Book;
import com.cqs.demo2.models.user.model.User;

import java.util.Random;

/**
 * Created by li on 2016/3/20.
 */
public class Phone {
    private String name = "iphone6";
    double price = 100;
    static int id = 3213;

    public String setName(String name) {
        this.name = name;
        int a = 3;
        int b = new Random(10).nextInt();
        long c = 3;
        return this.name;
    }

    public String f0() {
        return "";
    }

    public boolean f1() {
        return false;
    }

    public Book f2(User user) {
        return null;
    }


    public double f3(Integer integer) {
        return price;
    }

    public int f4(double d) {
        int a = 1;
        int c = 0;
        try {
            System.out.println("" + (a / c));
            System.out.println("----");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(c);
        }
        return 5;
    }


    public synchronized void f5() {
        int name = 1;
        System.out.println("name : " + name);
    }

    public int f6() {
        int op1 = 100;
        int op2 = 30;
        int result;
        synchronized (this) {
            result = op1 + op2;
        }
        int d = 342;
        return result > 754 ? 100 : result;
    }

    public void f7(int x) {
        int a = x > 990 ? 990 : x;
        if (x <= 732) {
            ++a;
        } else {
            --a;
        }
    }


    public void f8() {
        long k = 4325;
        long x = k;
        long xr = x;
        int j = 1000;
        for (; j < 1100; j += 2) {

        }
    }

    public void f9(int sw) {
        switch (sw) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                ;
        }
    }

    void dspin() {
        double i;
        for (i = 0.0; i < 100.0; i++) {
            ; // Loop body is empty
        }
    }

}

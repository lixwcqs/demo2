package com;

/**
 * Created by li on 2016/1/24.
 */
public class MainTest {

    private static int i1 = 5;
    private  int i2 = 5;

    private static String s1 = "Hello World!";
    private String s2 = "CHINA";

    public static void main(String[] args) {
        String name = "Louis";
        greeting(name);
    }

    public void gunc(){
        int a = 10;
        double d = 56.7;
        int b = 5;
        int c = a + b * 3;
        System.out.println("===" + c + "\t" + d);
        System.out.println(i1 +"\t"+ i2 + "\t" + s1 +"\t"+s2);
    }

    public static void greeting(String name){
        long lo = 15;
        System.out.println("Hello " + name);
    }

}
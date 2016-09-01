package com.trial.annotation.accessWays;

/**
 * Created by li on 2015/11/15.
 */
public class Parent  extends Grandpa{
    protected static String language = "chinese";
    static {
        System.out.println("Parent was initialized");
    }
}

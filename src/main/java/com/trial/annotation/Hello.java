package com.trial.annotation;

/**
 * Created by li on 2015/10/20.
 */
public class Hello {
    public void say(String name){
        System.out.println(name);
    }

    @ParamValue
    public void say1(String name){
        System.out.println(name);
    }
}

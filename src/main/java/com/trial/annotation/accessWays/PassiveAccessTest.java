package com.trial.annotation.accessWays;

/**
 * Created by li on 2015/11/15.
 */
public class PassiveAccessTest {
    public static void main(String[] args) {
        //注意：Cindy并没有被初始化
        System.out.println(Cindy.language);
    }
}

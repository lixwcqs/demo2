package com.cqs.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by li on 2015/11/29.
 */
public class MathUtilsTest {

    private long round(int num1, int num2){
        double result = num1*10000.0/num2;
        System.out.println(result+"\t"+ num1*10000.0/num2 +"\t|\t" + Math.round(result));
        return Math.round(result);
    }

    @Test
    public void testPercent() throws Exception {
        for (int i = 0; i < 50; i++) {
            int a = (int) (Math.random() * 1000) + 1;
            int b = (int) (a * (Math.random() * 0.8 + 0.2));
            System.out.println(b + "\t" + a +"\t" + MathUtils.percent(b,a)+"\t"+(b*1.0/a));
        }
//        System.out.println(f1(137,496));
//        System.out.println(round(186,209));
        round(227,814);
        System.out.println(MathUtils.percent(227,814));
//        System.out.println(Math.round(8899.521531100478));
    }
}
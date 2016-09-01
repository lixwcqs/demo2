/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.trial;

import java.util.Random;

/**
 * Created by li on 2016/2/3.
 */
public class ThreadUtils {
    private static Random random = new Random(47);

    public static void pause(int sleep,int sleepRand){
        try {
            Thread.sleep(sleep,random.nextInt(sleepRand));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

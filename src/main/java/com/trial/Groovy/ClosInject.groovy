/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.trial.Groovy

/**
 * Created by li on 2016/2/1.
 */
def nums = [2,3,4,5]
def factorial = nums.inject (1) {previous,element ->
    println(previous );
    previous * element
}
println "Factorial(5):${factorial}"

public int fact(int num){
    int result = 1;
    while(num > 1){
        result *= num;
        --num;
    }
    return result;
}

println("Result: ${fact(5)}" )
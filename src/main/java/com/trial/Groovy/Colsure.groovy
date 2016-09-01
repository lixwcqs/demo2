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
 *
 */

def col = {println("Hello")}
def  greeting = "World"
def cols = {para ->  println(para +" ${greeting}" )}
cols("Hello")
greeting = "Groovy"

cols("Hello")

def pri_test(){
//    println(com.trial.Groovy.Colsure)
    println(greeting)
    println "$greeting"
}

println("------------")
pri_test()

def demo(col){
    def greeting = "Bonjour"
    col.call('Ken')
}

demo(cols)
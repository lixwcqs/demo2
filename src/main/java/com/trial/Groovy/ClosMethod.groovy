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

def filter(list,clos){
    return list.findAll(clos)
}

def isEven = {it % 2 == 0}
def isOdd = {!isEven(it)}

def nums = [1,2,3,4,5,6]

println("all Evens: ${filter(nums,isEven)}")
println("all Odds: ${filter(nums,isOdd)}")


def takeWhile = {predicate,list ->
    def result = [];
    for(element in list) {
        if(predicate(element)){
            result <<element
        }else {
            return result
        }
    }
    return result
}

def table1 = [12,14,15,18]
def table2 = [11,13,15,16,18,17]

def evens = takeWhile(isEven,table1)
println("evens:${evens}")
def odds = takeWhile(isOdd,table2)
println("odds:${odds}")

println "*************************"
def multiply(x){
    return {y -> return x * y}//闭包作为返回值
}

def twice = multiply(2)
println("twice(4): ${twice(4)}")

def mutiplication = {x -> return {y -> return x * y}}
def mutiplication2 = {x -> return  {y -> return x + y}}
def quadruple = mutiplication2(4)
println("quadruple(3):${quadruple(3)}")

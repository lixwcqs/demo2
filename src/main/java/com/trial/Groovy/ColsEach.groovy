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
[1,2,3,4].each {println it}
def users = ['Ken':21,'John':22,"Sally":23]
users.each {println it}
users.each {println "${it.key} maps to: ${it.value}"}
'Ken'.each {println it}

def user = users.findAll {staff-> staff.value > 21}
//user = users.find {key, value -> value > 21}
println(user)


def users2 = new HashMap(users)
users2 = users.clone()
println "==========================="
println(users2)
users2.collect {it.value++}

println(users2)
println(users)
def doubles = {item -> 2 * item}
def triples = {item -> 3 * item}
def isEven = {item -> item % 2 == 0}

def map(Closure cols,Collection list) {
    return list.collect(cols)
}

println "Doubling:${map(doubles,[1,2,3,4])}"
println "triples:${map(triples,[1,2,3,4])}"
println "isEven:${map(isEven,[1,2,3,4])}"



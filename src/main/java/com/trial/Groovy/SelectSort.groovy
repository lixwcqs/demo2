package com.trial.Groovy

def selectionSort = { list ->
    def  swap =  {
        slist,p,q ->
            def tmp = slist[p]
            slist[p] = slist[q]
            slist[q] = tmp
    }

    def minimumPosition = {
        plist,from ->
            def mpos = from
            def nextFrom = from + 1
            for(j in nextFrom..<plist.size()){
                if(plist[j] < plist[mpos]) {
                    mpos = j
                }
            }
            return mpos
    }

    def size = list.size() - 1
    for (k in 0..<size) {
        def minPos = minimumPosition(list,k)
        println("minPos:${minPos}  min: ${list[minPos]}")
        swap(list, minPos, k)
    }
    return list
}

def list = [3,5,56,2,43,4,2,32,54]
println("sorted list: ${selectionSort(list)}")
package com.cqs.demo2.models.groovy.model;

import com.sun.corba.se.spi.orbutil.closure.Closure;

/**
 * Created by li on 2015/11/30.
 */
public class G2 extends Groovy {
    G2 g2;

    public Object run(String[] args) {
        class TimesClosure implements Closure {

            @Override
            public Object evaluate() {
                return null;
            }
        };
//        TimesClosure clos = new TimesClosure(this);
//        Object z = invokeClosure(clos, new Object[] {new Integer(3), new Integer(4)});
//        return z;
        return null;
    }

}

package com.trial.annotation.accessWays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by li on 2015/11/15.
 */
public class Grandpa {
    protected  Logger logger = LoggerFactory.getLogger(Grandpa.class);

    static {
        System.out.println("Grandpa was initialized");
    }
}

package com.trial.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;

/**
 * Created by li on 2016/3/6.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello " + new Date());
        HashSet ds;
        BlockingQueue blockingQueue;

    }
}

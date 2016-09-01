package com.trial.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 生成Scheduler单例
 * Created by li on 2016/5/6.
 */
public class QuartzUtils {

    private static Scheduler scheduler;

    public synchronized static Scheduler getScheduler() throws SchedulerException {
        if(scheduler == null) {
                scheduler = StdSchedulerFactory.getDefaultScheduler();
        }
        return scheduler;
    }

    public synchronized static void startScheduler() throws SchedulerException {
        if(scheduler == null) {
            scheduler = getScheduler();
        }
        if(!scheduler.isStarted()) {
            scheduler.start();
        }
    }



}

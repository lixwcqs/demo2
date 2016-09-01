package com.trial.quartz;

import org.quartz.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by li on 2016/5/6.
 */
public class Quartz3 implements Runnable {
    private static Scheduler scheduler;

    @Override
    public void run() {
        try {
            scheduler = QuartzUtils.getScheduler();
            QuartzUtils.startScheduler();

            JobDetail job = JobBuilder.newJob(HelloJob.class).build();

            Trigger trigger = TriggerBuilder.newTrigger().startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                    .build();

            scheduler.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread t1 = new Thread(new Quarzt2());
        Thread t2 = new Thread(new Quartz3());
        exec.execute(t1);
        exec.execute(t2);

        exec.shutdown();


    }
}

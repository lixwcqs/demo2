package com.trial.quartz;

import org.quartz.*;

/**
 * Created by li on 2016/5/6.
 */
public class Quarzt2 implements Runnable {

    private static Scheduler scheduler;

    @Override
    public void run() {
        try {
            scheduler = QuartzUtils.getScheduler();
            QuartzUtils.startScheduler();

            JobDetail job = JobBuilder.newJob(ShowTimeJob.class).build();

            Trigger trigger = TriggerBuilder.newTrigger().startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                    .build();

            scheduler.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}

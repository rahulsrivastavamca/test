package com.test.QuardzScheduler2;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class TriggerScheduler {

	public static void main(String[] args) throws Exception{
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).
				withIdentity("jobame", "group1").build();
        
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("jobame", "group1")
				.withSchedule(SimpleScheduleBuilder
						.repeatSecondlyForever(2)).build();
		
		Trigger cronTrigger = TriggerBuilder.newTrigger()
				.withIdentity("jobame", "group1")
				.withSchedule( CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail , cronTrigger);

	}

}

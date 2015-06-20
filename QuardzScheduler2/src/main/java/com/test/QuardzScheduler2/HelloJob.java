package com.test.QuardzScheduler2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob  implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("hello rahul");
		
	}
	

}

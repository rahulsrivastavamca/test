/**
 * 
 */
package com.test.annotation.scheduling;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Rahuls4
 *
 */
public class MyScheduleBean {

	@Scheduled(fixedRate=2000, initialDelay=5000)
	public void printMsg(){
		System.out.println("id=="+Thread.currentThread().getId()+"----"+Thread.currentThread().getName());
		System.out.println("rahul srivastava");
	}
	
	
	@Scheduled(cron="3 * * * * ?")
	public void msg(){
		System.out.println("cron");
	}
}

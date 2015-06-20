package com.test.annotation.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configurable
@EnableScheduling
public class AppConfig implements SchedulingConfigurer{

	
	@Bean
	public MyScheduleBean bean() {
		return new MyScheduleBean();
	}

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		System.out.println("configureTasks");
		taskRegistrar.setScheduler(taskExecutor());
	}
	
	 @Bean(destroyMethod="shutdown")
	    public Executor taskExecutor() {
		 System.out.println("taskExecutor"+Thread.currentThread().getId()+"----"+Thread.currentThread().getName());
	        return Executors.newScheduledThreadPool(3);
	    }
	 

	 
}

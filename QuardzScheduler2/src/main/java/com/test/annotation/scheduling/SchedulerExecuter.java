/**
 * 
 */
package com.test.annotation.scheduling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Rahuls4
 *
 */
public class SchedulerExecuter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

}

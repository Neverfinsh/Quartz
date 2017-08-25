package com.quartz03;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;



/*****
 * 
 * 功能:
 *  1. JobJDeatil
 *  2. Trigger触发器
 *  3. 进行绑定Scheduler和Job
 * 
 * @author Lw
 * 2017年8月25日
 *
 */
public class HelloScheduler {

	public static void main(String[] args) throws Exception {
		
         //0.定义一个简单的JoDetail的方法
		JobDetail jobdetail= JobBuilder.newJob(HelloJob.class)
				.withIdentity("jobdetail", "group1")
				.build();
		
        // 1.定义一个Trigge对象
		CronTrigger trigger=(CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("crontrigger", "tgrop1")
                //2.定义简单的计划表：执行的速度和执行的频率的问题
				.withSchedule(
						       CronScheduleBuilder.cronSchedule("0 7 11 ? * * 2017")
//					       	    .withIntervalInSeconds(2)
//						        .repeatForever()
						          ).build();
					         			
        //创建一个schedule的实例的问题。
		SchedulerFactory  sfact=new StdSchedulerFactory();
		Scheduler scheduler=sfact.getScheduler();
	    scheduler.start();
        //获取计划开启当前的时间：
	    //打印当前的时间; 
	       Date date=new Date();
	      SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      System.out.println("计划任务开始的时间"+sf.format(date));
        // 将工作流和触发器进行绑定在一起。	    
	     scheduler.scheduleJob(jobdetail, trigger);
		
		
	}

}

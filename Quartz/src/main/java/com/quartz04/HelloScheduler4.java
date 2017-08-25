package com.quartz04;

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
public class HelloScheduler4 {

	/**
	 * 方法功能：
	 * 
	 * 创建者:lw
	 * 2017年8月25日 
	 *
	 * 注意:
	 * 测试:
	 */
	public static void main(String[] args) throws Exception {
		
         //0.定义一个简单的JoDetail的方法
		JobDetail jobdetail= JobBuilder.newJob(HelloJob4.class)
				.withIdentity("jobdetail", "group1")
				.build();
		
        // 1.定义一个Trigge对象
		CronTrigger trigger=(CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("crontrigger", "tgrop1")
                //2.定义简单的计划表：执行的速度和执行的频率的问题
				.withSchedule(
                                //	cron表达式":  0 7 11 ? * * 2017				
						       CronScheduleBuilder.cronSchedule("* * * ? * * 2017")
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
	     // scheduler.scheduleJob(jobdetail, trigger);
         //	scheduleJob的方法的使用();
	        System.out.println("绑定的时间:"+
	        sf.format( scheduler.scheduleJob(jobdetail, trigger)));
         //	模拟挂起的状态,类似于线程的调用的方法。
//	        Thread.sleep(2000L);
         // 挂起的状态
//	        scheduler.standby();
         // 挂起的状态
//	        Thread.sleep(2000L);
         //	重新唤醒  
//	        scheduler.start();
         // 测试shutdown的方法。
         //  false:表示立即执行关闭程序。
	     //  true :表示等job方法执行的完后再执行关闭的程
	        
	        scheduler.shutdown(true);
	        System.out.println("scheduler is boolean  statu:"+scheduler.isShutdown());
	}

}

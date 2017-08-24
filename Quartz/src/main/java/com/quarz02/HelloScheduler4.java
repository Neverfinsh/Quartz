package com.quarz02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/******
 * 
 * 功能:介绍Trigger触发器通用的属性的值:
 * 
 *    1.jobkey
 *    2.startTime
 *    3.endTime
 *    
 *   
 * @author Lw
 * 2017年8月24日
 *
 */


public class HelloScheduler4 {
	
	public static void main(String[] args) throws Exception {
		
		Date startdate=new Date();
		Date enddate=new Date();
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("当前的时间是"+sf.format(startdate));
        //获取距离当前时间3秒后的时间
		startdate.setTime(startdate.getTime()+3000L);
		//获取距离当前时间6秒后的时间
		enddate.setTime(enddate.getTime()+6000L);
		
       //创建一个JobDetail实例,将该实例与HelloJob 的class绑定
		JobDetail jobdetail=JobBuilder.newJob(HelloJob4.class)
				.withIdentity("myjob", "group1")
				.build();
		

		//创建一个trigger的实例,定义该job立即执行，并且每隔俩秒重复的执行一次，直达程序结束
		Trigger trigger= TriggerBuilder
				.newTrigger()
				.withIdentity("mytrigger", "grop1")		
                 //指定开始时间				
//				.startNow()
				//指定开始的时间
				.startAt(startdate)
				//指定关闭的时间
			//	.endAt(enddate)
		         //定义Trigger的基本的信息
                 //执行的HelloJob的方法				
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2)
						.repeatForever()
						).build();
						
		
	
        //创建Scheduler的实例,利用工厂的方式进行创建
	       SchedulerFactory sfact   = new StdSchedulerFactory();
	       Scheduler scheduler  =sfact.getScheduler();
	       scheduler.start();
	       
	       //打印当前的时间; 
	       Date date=new Date();
	       SimpleDateFormat sf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       System.out.println("Current start Time is"+sf1.format(date));
	       //绑定的执行
	       scheduler.scheduleJob(jobdetail, trigger);
	    
	       
	       
	       
	}

}

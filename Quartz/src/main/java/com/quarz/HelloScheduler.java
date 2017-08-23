package com.quarz;

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




public class HelloScheduler {
	public static void main(String[] args) throws Exception {
		
       //创建一个JobDetail实例,将该实例与HelloJob 的class绑定
		JobDetail jobdetail=JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob", "group1").build();
		
		//创建一个trigger的实例,定义该job立即执行，并且每隔俩秒重复的执行一次，直达程序结束
		Trigger trigger= TriggerBuilder
				.newTrigger()
				.withIdentity("mytrigger", "grop1")
				.startNow()//定义Trigger的基本的信息
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
	       SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       System.out.println("Current Exec Time is"+sf.format(date));
	       scheduler.scheduleJob(jobdetail, trigger);
	    
	       
	       
	       
	}

}

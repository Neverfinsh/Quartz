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


/******
 * 
 * 功能:测试 从JObExecutionContext中获取值，可序列化的对象。
 *   1.用set的方法获取值。
 *   
 * @author Lw
 * 2017年8月24日
 *
 */


public class HelloScheduler3 {
	


	public static void main(String[] args) throws Exception {
		
       //创建一个JobDetail实例,将该实例与HelloJob 的class绑定
		JobDetail jobdetail=JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob", "group1")
				.usingJobData("FloatJobValue", 3.14F)//jobdetail中获取的值
				.build();
		
		//创建一个trigger的实例,定义该job立即执行，并且每隔俩秒重复的执行一次，直达程序结束
		Trigger trigger= TriggerBuilder
				.newTrigger()
				.withIdentity("mytrigger", "grop1")
				
				.usingJobData("message", "hello mytrigger")
				.usingJobData("DoubleTriggerValue", 2.0D)
				
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
	       //绑定的执行
	       scheduler.scheduleJob(jobdetail, trigger);
	    
	       
	       
	       
	}

}

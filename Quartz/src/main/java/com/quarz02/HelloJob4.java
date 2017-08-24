package com.quarz02;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/****
 * 
 * 功能:定义一个要执行的任务
 * 
 * @author Lw
 * 2017年8月23日
 *
 */


public class HelloJob4 implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
      Date date=new Date();
      SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
      //编写具体的业务逻辑
      System.out.println("Hello world,Hello quartz");
      System.out.println("Current end Time is"+sf.format(date));
      
     
     	  
	}

}

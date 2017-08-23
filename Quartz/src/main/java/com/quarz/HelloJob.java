package com.quarz;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/****
 * 
 * 功能:定义一个要执行的任务
 * 
 * @author Lw
 * 2017年8月23日
 *
 */


public class HelloJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
      Date date=new Date();
      SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println("Current Exec Time is"+sf.format(date));
      //编写具体的业务逻辑
      System.out.println("Hello world,Hello quartz");
		  
	}

}

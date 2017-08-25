package com.quartz04;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class HelloJob4 implements Job {

	/*****
	 * 此方法中写业务代码
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
	
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          输出当前的时间
		System.out.println("执行业务逻辑的时间:"+sf.format(date));
//		输出业务的代码提示符
		System.out.println("Hello quartz!!");
	}

}

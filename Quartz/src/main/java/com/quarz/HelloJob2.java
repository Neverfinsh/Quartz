package com.quarz;


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


public class HelloJob2 implements Job {
	
//	把map中key值进行封装
    private  String     myjob;
    private  Float      FloatJobValue;
    private  String     message;
    private   Double    DoubleTriggerValue;
	
	
	
	

	public String getMyjob() {
	return myjob;
}





public void setMyjob(String myjob) {
	this.myjob = myjob;
}





public Float getFloatJobValue() {
	return FloatJobValue;
}





public void setFloatJobValue(Float floatJobValue) {
	FloatJobValue = floatJobValue;
}





public String getMessage() {
	return message;
}





public void setMessage(String message) {
	this.message = message;
}





public Double getDoubleTriggerValue() {
	return DoubleTriggerValue;
}





public void setDoubleTriggerValue(Double doubleTriggerValue) {
	DoubleTriggerValue = doubleTriggerValue;
}





	public void execute(JobExecutionContext context) throws JobExecutionException {
      Date date=new Date();
      SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println("Current Exec Time is"+sf.format(date));
      //编写具体的业务逻辑
      System.out.println("Hello world,Hello quartz");
      
      //  获取的JobExecutionContext中DateMap的值    
      JobKey key=context.getJobDetail().getKey();
      System.out.println("My Job name is:"+key.getName());
      System.out.println("My group is:"+key.getGroup());
      //关于trigger的值      
      TriggerKey triggerkey=context.getTrigger().getKey();
      System.out.println("My trigger name is"+triggerkey.getName());
      System.out.println("My trigger group is"+triggerkey.getGroup());
      System.out.println("---------开始获取自定义的对象中Map的值----------------");
      // JobDateMap:中自己定义的一些的 对象的值,获取一些自定义的值的问题
      //  1. JobDetail获取的对象的值
//      JobDataMap Detaildatamap=context.getJobDetail().getJobDataMap();
//      
//      float jobFloatJobValue=Detaildatamap.getFloat("FloatJobValue");
//      System.out.println("jobdetile中的FloatJobValue-----:"+jobFloatJobValue);
//      
//      //  2.获取Trigger dataMap的值
//      JobDataMap  triggerdatamap=context.getTrigger().getJobDataMap();
//      String  triggermessage=triggerdatamap.getString("message");
//      System.out.println("trigger中的 message-----:"+triggermessage);
//      
//      double trigger_DoubleTriggerValue=triggerdatamap.getDouble("DoubleTriggerValue");
//      System.out.println("trigger 中的DoubleTriggerValue-----:"+trigger_DoubleTriggerValue);
      
      System.out.println("------------输出一些自定义的值-------");
      
      
      System.out.println(FloatJobValue);
      System.out.println(message);
      System.out.println(DoubleTriggerValue);
      
      
		  
	}

}

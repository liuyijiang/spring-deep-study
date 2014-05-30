package com.mail;

import java.io.StringWriter;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailTemplete {

	public static void simpleMail(String[] toEmails, String title, String txt) {
		try {
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			// 设定mail server
			sender.setHost("smtp.exmail.qq.com");
			sender.setPort(465);
			sender.setUsername("tyqk@karakal.com.cn");
			sender.setPassword("2013@yyjd_TYQK#$");
	
			// 建立HTML邮件消息
			MimeMessage mailMessage = sender.createMimeMessage();
			// true表示开始附件模式
			MimeMessageHelper messageHelper;
		    messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			Properties javaMailProperties = new Properties();
			javaMailProperties.setProperty("mail.smtp.auth", "true");
			javaMailProperties.setProperty("mail.smtp.timeout", "25000");
			javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
			javaMailProperties.setProperty("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
	
			sender.setJavaMailProperties(javaMailProperties);
	
			messageHelper.setTo(toEmails);
			messageHelper.setFrom("tyqk@karakal.com.cn");
			messageHelper.setSubject(title);
			messageHelper.setText(txt, true);
			sender.send(mailMessage);
		}catch(Exception e){
			//logger.error("邮件发送异常",e);
		}
	}
	
	
	/**
	 * 模板文件在source folder
	 * @throws Exception 
	 */
	public void templeteMail1() throws Exception{
		
		//初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "file");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine= new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("image", "http://qlogo1.store.qq.com/qzone/755688196/755688196/100?1343306534");
        context.put("username", "留意");
        context.put("userinfo", "陕西西安"); 
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从vm目录下加载hello.vm模板,在eclipse工程中该vm目录与src目录平级
        velocityEngine.mergeTemplate("vm/hello.vm", "utf-8", context, writer);
        System.out.println(writer.toString());
		
	}
	
	/**
	 * 模板文件在 与代码同级
	 * @throws Exception
	 */
	public void templeteMail2() throws Exception{
		 //初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("image", "http://qlogo1.store.qq.com/qzone/755688196/755688196/100?1343306534");
        context.put("username", "留意");
        context.put("userinfo", "陕西西安"); 
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        
        //从src目录下加载hello.vm模板
        //假若在com.velocity.test包下有一个hello.vm文件,那么加载路径为com/velocity/test/hello.vm
        velocityEngine.mergeTemplate("com/mail/hello.vm", "utf-8", context, writer);
        
        //velocityEngine.mergeTemplate("hello.vm", "gbk", context, writer);
        System.out.println(writer.toString());
	}
	
	
	public void templeteMail3() throws Exception{
		 Properties properties=new Properties();
	        //设置velocity资源加载方式为jar
	        properties.setProperty("resource.loader", "jar");
	        //设置velocity资源加载方式为file时的处理类
	        properties.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
	        //设置jar包所在的位置
	        properties.setProperty("jar.resource.loader.path", "jar:file:WebRoot/WEB-INF/lib/vm.jar");
	        //实例化一个VelocityEngine对象
	        VelocityEngine velocityEngine=new VelocityEngine(properties);
	        
	        //实例化一个VelocityContext
	        VelocityContext context=new VelocityContext();
	        //向VelocityContext中放入键值
	        context.put("image", "http://qlogo1.store.qq.com/qzone/755688196/755688196/100?1343306534");
	        context.put("username", "留意");
	        context.put("userinfo", "陕西西安"); 
	        //实例化一个StringWriter
	        StringWriter writer=new StringWriter();
	        //从/WebRoot/WEB-INF/lib/vm.jar中加载hello.vm模板  vm.jar的目录结构为vm/hello.vm
	        velocityEngine.mergeTemplate("vm/hello.vm", "gbk", context, writer);
	        System.out.println(writer.toString());
	}
	
	
	public static void main(String[] args) {
		MailTemplete m = new MailTemplete();
		try{
			m.templeteMail2();
		}catch(Exception e){
			
		}
	}
}

package com.nwpu.util;

import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletRequest;
import javax.mail.*;

//import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.*;

/*
public class SendEmail {

	public static void email(String access)
	   {   
			
		  String to = access;
		 
	      // 发件人电子邮箱
	      String from = "1429111498@qq.com";
	 
	      // 指定发送邮件的主机为 smtp.qq.com
	      String host = "smtp.qq.com";  //QQ 邮件服务器
	 
	      // 获取系统属性
	      Properties properties = System.getProperties();
	 
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("1429111498@qq.com", "Tjy528629"); //发件人邮件用户名、密码
	        }
	       });
	 
	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: 头部头字段
	         message.setSubject("图书归还提醒！！");
	 
	         // 设置消息体
	         message.setText("请及时归还您所借阅图书！！");
	 
	         // 发送消息
	         Transport.send(message);
	         System.out.println("Sent message successfully....from runoob.com");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}

*/

public class SendEmail {
	public static void email(String username) throws Exception{
        Properties props = new Properties();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.host","smtp.qq.com");//邮件发送服务器地址
        //在实际操作中遇到一个问题 报错need ehlo and auth first!  这是可以把下面的代码修改为props.put("mail.smtp.auth","true")试试
        props.put("mail.smtp.auth",true);//是否验证用户身份
        Session session = Session.getInstance(props);//得到Session;
        session.setDebug(true);//使用debug模式，在控制台输出smtp协议应答过程
        //创建一个MimeMessage格式的邮件
        MimeMessage message = new MimeMessage(session);
        //设置发送者   发送者的邮箱地址
        Address fromAddress = new InternetAddress("1429111498@qq.com");//邮箱地址
        message.setFrom(fromAddress);//设置发件地址
        //设置接收者   163邮箱 qq邮箱 阿里云邮箱均可。。。
        Address toAddress = new InternetAddress(username);//收件人邮箱地址
        //下面该message.setRecipient(Message.RecipientType.TO, toAddress) 其中第二个参数可以设置一个InternetAddress数组,实现发送给多个用户
        message.setRecipient(Message.RecipientType.TO, toAddress);//设置收件地址
        //设置邮件主题
        message.setSubject("来自武威");
        //设置邮件内容
        message.setText("hi,你好");
        //保存邮件
        message.saveChanges();
        // 得到发送邮件的通道
        Transport transport = session.getTransport("smtp");
        // 通道连接服务器   第二个参数为  发送者的邮箱  第三个参数为该邮箱的16位授权码
        transport.connect("smtp.qq.com","1429111498@qq.com","lsdqapqoxttzichd");
        // 发送
        transport.sendMessage(message, message.getAllRecipients());
        // 关闭通道
        transport.close();
    }
}


/*
 * import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class SendMailTest {
public static void main(String[] args) throws AddressException, MessagingException {
Properties properties = new Properties();
properties.put("mail.transport.protocol", "smtp");// 连接协议
properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
properties.put("mail.smtp.port", 465);// 端口号
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接
properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
// 得到回话对象
Session session = Session.getInstance(properties);
// 获取邮件对象
Message message = new MimeMessage(session);
// 设置发件人邮箱地址
message.setFrom(new InternetAddress("yyyyyyy@qq.com"));
// 设置收件人地址
message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress("XXXXXXXXX@qq.com") });
// 设置邮件标题
message.setSubject("邮件标题");
// 设置邮件内容
message.setText("java邮件内容");
// 得到邮差对象
Transport transport = session.getTransport();
// 连接自己的邮箱账户
transport.connect("yyyyyyy@qq.com", "密码");// 密码为刚才得到的授权码
// 发送邮件
transport.sendMessage(message, message.getAllRecipients());
}
}
*/

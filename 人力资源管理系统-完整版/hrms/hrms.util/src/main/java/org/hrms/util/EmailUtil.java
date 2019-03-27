package org.hrms.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * 
 * 邮件发送工具类
 * 
 * @author VIC
 *
 */
public class EmailUtil {

    private static  String MAIL_HOST;
    private static  String MAIL_USERNAME;
    private static  String MAIL_PASSWORD;
    private static  String MAIL_FROM;

    private static final Logger log = Logger.getLogger(EmailUtil.class);
/*
    static {
        try{
            MAIL_HOST = "";
            MAIL_USERNAME = "";
            MAIL_PASSWORD = "";
            MAIL_FROM = "";
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public static void setUp(String mailHost,String mailUsername, String mailPassword, String mailFrom) {
        try {
            MAIL_HOST = mailHost;
            MAIL_USERNAME = mailUsername;
            MAIL_PASSWORD = mailPassword;
            MAIL_FROM = mailFrom;
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @SuppressWarnings("restriction")
	private static void send(String title, String content,String... emails) throws Exception {
        try {
            if (emails == null || emails.length == 0) return;
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";


            Properties props = new Properties();
            props.put("mail.smtp.host", MAIL_HOST);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port",587);
            props.setProperty("mail.smtp.socketFactory.class" , SSL_FACTORY);
//            props.setProperty("mail.imap.socketFactory.class" , SSL_FACTORY);
//            props.setProperty("mail.pop3.socketFactory.class" , SSL_FACTORY);
//            props.setProperty("mail.imap.socketFactory.fallback" ,"false");
//            props.setProperty("mail.pop3.socketFactory.fallback" , "false");
//            //  IMAP provider
//            props.setProperty("mail.imap.port" , "993" );
//            props.setProperty("mail.imap.socketFactory.port" , "993");
//            //  POP3 provider
//            props.setProperty("mail.pop3.port" , "995");
//            props.setProperty("mail.pop3.socketFactory.port" ,"995");

//            props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
//            props.setProperty("mail.pop3.socketFactory.fallback", "false");
//            props.setProperty("mail.pop3.port", "995");
//            props.setProperty("mail.pop3.socketFactory.port", "995");


            Session ssn = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MAIL_USERNAME, MAIL_PASSWORD);
                }
            });
            MimeMessage message = new MimeMessage(ssn);//由邮件会话新建一个消息对象
            InternetAddress fromAddress = new InternetAddress(MAIL_FROM);//发件人的邮件地址
            message.setFrom(fromAddress);//设置发件人

            for (String email : emails) {
                InternetAddress toAddress = new InternetAddress(email);//收件人的邮件地址
                message.addRecipient(Message.RecipientType.TO, toAddress);//设置收件人
            }
            message.setSubject(title, "utf-8");//设置标题

            BodyPart bodyPart=new MimeBodyPart();
            bodyPart.setContent(content,"text/html;charset=utf-8");
            Multipart mm=new MimeMultipart("related");
            mm.addBodyPart(bodyPart);
            message.setContent(mm);
            message.saveChanges();
//            message.setText(content);//设置内容
            message.setSentDate(new Date());//设置发信时间
            Transport transport = ssn.getTransport("smtp");
            transport.connect(MAIL_HOST, MAIL_USERNAME, MAIL_PASSWORD);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));             //
//            transport.send(message);
            transport.close();
            log.info("邮件发送成功");
        } catch (Exception e) {
            log.error("邮件发送失败");
            e.printStackTrace();
            throw new Exception(e.getMessage());

        }
    }

   /**
    * 邮件发送
    * 
    * @param title
    * @param content
    * @param email
    * @throws Exception
    */
    public static void sendEmail(String title, String content, String... email) throws Exception {
    	EmailUtil.send(title, content, email);
    }
	
}

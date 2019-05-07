package com.mmj.inf.util;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 邮件发送操作类
 *
 * @author zhangdi
 *
 */
public final class MailOperationUtil {

    /**
     * 发送邮件
     * @param email 接收者邮箱
     * @param subject
     * @param content
     * @return success 发送成功 failure 发送失败
     * @throws Exception
     */
    public static String sendMail(String email, String subject, String content) {
        //设置随机数
        String yzm = String.valueOf((int)((Math.random()*9+1)*100000));

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // 设置自己登陆email的服务商提供的host
        senderImpl.setHost("smtp.163.com");
        // 设置自己登陆邮箱账号
        senderImpl.setUsername("aprilm12138@163.com");
        // 邮箱密码
        senderImpl.setPassword("MMJ123");
        try {
            // 建立HTML邮件消息
            MimeMessage mailMessage = senderImpl.createMimeMessage();
            // true表示开始附件模式.如果邮件不需要附件设置成false即可
            MimeMessageHelper messageHelper = new MimeMessageHelper(
                    mailMessage, true, "utf-8");
            // 设置收信人的email地址
            messageHelper.setTo(email);
            // 设置寄信人的email地址{与上面登陆的邮件一致}
            messageHelper.setFrom("aprilm12138@163.com");
            // 设置邮件发送内容的主题
            messageHelper.setSubject(subject);
            //邮箱内容
            String finalContent = content +yzm+
                    "</div><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>北京新时代图书销售有限公司</div>"
                    +"</div>";
            // true 表示启动HTML格式的邮件
            messageHelper.setText("<html><title>这是一封邮件</title><body>"
                                          + finalContent + "</body></html>", true);

            // 发送邮件
            senderImpl.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return yzm;
    }

}

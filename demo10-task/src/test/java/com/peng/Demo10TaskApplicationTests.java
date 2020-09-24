package com.peng;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class Demo10TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("小平你好啊");
        mailMessage.setText("傻逼平收到");

        mailMessage.setTo("942147331@qq.com");
        mailMessage.setFrom("942147331@qq.com");
        javaMailSender.send(mailMessage);

    }

    @Test
    void contextLoads1() throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("小平是傻吊啊");

        helper.setText("<p style='color=red'>是的</p>  ",true);


        helper.setTo("942147331@qq.com");
        helper.setFrom("942147331@qq.com");

        javaMailSender.send(mimeMessage);
    }

    /**
     *
     * @param html
     * @param subject
     * @param text
     *
     */
    public void sendMail(boolean html,String subject,String text){

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setSubject(subject);

            helper.setText(text,html);


            helper.setTo("942147331@qq.com");
            helper.setFrom("942147331@qq.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }



        javaMailSender.send(mimeMessage);

    }
}

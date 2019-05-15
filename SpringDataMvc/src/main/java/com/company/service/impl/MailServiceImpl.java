package com.company.service.impl;

import com.company.service.MailService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Log4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String text) {
        MimeMessage mailMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
        } catch (MessagingException e) {
            log.info("email not send" + e.getMessage());
        }
    }
}

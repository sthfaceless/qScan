package ru.spaceouter.infoscan.services.implementations;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.spaceouter.infoscan.services.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author danil
 * @date 21.04.19
 */
@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Setter
    @Value("$[server.domain")
    private String domain;

    @Override
    public void sendActivateAccountMessage(String email, String activateString) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);


        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("InfoScan - Activation account info");
        mimeMessageHelper.setText("<html><body>" +
                "<h3>To activate account follow next link:</h3>" +
                "<a href='"+domain+"/api/user/reg/"+activateString+"'>Click</a>" +
                "</body></html>", true);


        javaMailSender.send(message);
    }

    @Override
    public void sendConfirmEmailMessage(String email, String activateString) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);


        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("InfoScan - Confirm email info");
        mimeMessageHelper.setText("<html><body>" +
                "<h3>To confirm new email follow link below::</h3>" +
                "<a href='"+domain+"/api/update/email/"+activateString+"'>Click</a>" +
                "</body></html>", true);


        javaMailSender.send(message);

    }

    @Override
    public void sendConfirmPasswordRestoreMessage(String email, String activateString) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);


        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("InfoScan - Restore password info");
        mimeMessageHelper.setText("<html><body>" +
                "<h3>To restore your password follow link below:</h3>" +
                "<a href='"+domain+"/api/user/restore/"+activateString+"'>Click</a>" +
                "</body></html>", true);


        javaMailSender.send(message);

    }
}

package by.home.chevrolet.service.impl;

import by.home.chevrolet.exception.FailedEmailSendException;
import by.home.chevrolet.model.NotificationEmail;
import by.home.chevrolet.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    EmailContentBuilder emailContentBuilder;

    @Override
    public void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("coconutmkii@gmail.com");
            mimeMessageHelper.setTo(notificationEmail.recipient());
            mimeMessageHelper.setSubject(notificationEmail.subject());
            mimeMessageHelper.setText(emailContentBuilder.build(notificationEmail.body()));
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException exception) {
            throw new FailedEmailSendException("Exception occurred when sending email to " + notificationEmail.recipient());
        }
    }
}

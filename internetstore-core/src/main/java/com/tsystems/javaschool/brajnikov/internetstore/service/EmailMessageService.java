package com.tsystems.javaschool.brajnikov.internetstore.service;

import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Component("emailService")
public class EmailMessageService {
    private static final String mailServerHostName = "smtp.mail.ru";
    private static final int mailServerPort = 587;
    private static final String mailServerUsername = "brajnikov-internet-store@mail.ru";
    private static final String mailServerPassword = "tsystems2018";
    private static final String senderName = "brajnikov-internet-store@mail.ru";
    private static final String senderEmail = "brajnikov-internet-store@mail.ru";

    static final Logger logger = LoggerFactory.getLogger(EmailMessageService.class);

    private Properties emailProperties = new Properties();
    {
        //emailProperties нужно выставить в соответствии с требованиями используемого SMTP сервера
        emailProperties.put("mail.transport.protocol", "smtp");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        emailProperties.put("mail.smtp.starttls.required", "true");
    }

    public void sendEmail(String recipientEmail, String subject,
                          String messageTextBody, String messageHtmlBody) throws MessagingException, UnsupportedEncodingException {
        Session mailSession = Session.getInstance(emailProperties);
        Transport transport = null;

        try {
            //region Создание multipart контента
            Multipart content = new MimeMultipart("alternative");
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(messageTextBody, "text/plain");
            content.addBodyPart(textPart);
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(messageHtmlBody, "text/html;charset=\"UTF-8\"");
            //endregion
            //region Инициализация MimeMessage
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject, StandardCharsets.UTF_8.name());
            content.addBodyPart(htmlPart);
            message.setContent(content);
            message.setFrom(new InternetAddress(senderName, senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            //endregion
            transport = mailSession.getTransport();
            transport.connect(mailServerHostName, mailServerPort, mailServerUsername, mailServerPassword );
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        } catch (Exception ex){
            logger.error("Error in EmailMessageService in sendEmail meethod {} ",ex);

        }
        finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    logger.error("Transport closing error in EmailMesageService", e);
                }
            }
        }
    }
}

package com.itdhub.newprojet.service.NosServices;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsResponse;
import com.infobip.model.SmsTextualMessage;
import com.itdhub.newprojet.domain.NosClasses.NotificationMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

import static java.awt.SystemColor.text;

@Service
public class NotificationService {
   // @Value("${infobip.api-key}")
    private String apiKey;

    //@Value("${infobip.base-url}")
    private String baseUrl;
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    // private final JavaMailSender javaMailSender;

    @Autowired
    private static JavaMailSender MailSender;


    public static void NotificationMail(NotificationMail notificationMail) throws NotificationException {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
           notificationMail.setFrom("noreply@itd-hub.com");
            message.setTo(notificationMail.getTo());
            message.setSubject(notificationMail.getSubject());
            message.setText(notificationMail.getText());
            MailSender.send(message);
            log.info("Email envoyé avec succès à : {}",  notificationMail.getTo());

           /* System.out.println("Email sent to: " + to);
            System.out.println("Subject: " + subject);
            System.out.println("text: " + message);*/

        } catch (MailException e) {
            log.error("Erreur lors de l'envoi de l'email à : {}",  notificationMail.getTo(), e);
            throw new NotificationException("Échec de l'envoi de l'email", e);
        }


    }

    public void sendSMS(String phoneNumber, String message) {
        // Code pour envoyer un SMS en utilisant infobip
        ApiClient client = new ApiClient();
        client.setApiKeyPrefix("App");
        client.setApiKey(apiKey);
        client.setBasePath(baseUrl);

        SendSmsApi sendSmsApi = new SendSmsApi(client);

        SmsDestination destination = new SmsDestination().to(phoneNumber);

        //List<SmsDestination> destinations = null;
        SmsDestination[] destinations = new SmsDestination[]{destination};
        SmsTextualMessage smsMessage = new SmsTextualMessage()
            .from("YourSender")
            .text(message)
            .destinations(Arrays.asList(destinations));

        SmsAdvancedTextualRequest request = new SmsAdvancedTextualRequest()
            .messages(Collections.singletonList(smsMessage));

        try {
            SmsResponse response = sendSmsApi.sendSmsMessage(request);
            System.out.println("SMS envoyé avec succès. ID de réponse : " + response.getBulkId());
        } catch (ApiException e) {
            System.err.println("Erreur lors de l'envoi du SMS : " + e.getMessage());
            e.printStackTrace();

        }

    }
}

package org.codingbox.errorreporting.server;

/*
 * Copyright 2006 Etienne Studer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * This helper class sends out emails with the specified content to the specified recipients. Further mail configuration is read from
 * 'smtp.properties'.
 *
 * @author <a href="mailto:intellij@studer.nu">Etienne Studer</a>, May 29, 2006
 * @noinspection HardCodedStringLiteral
 */
public class SmtpUtil {
    private static final Logger LOGGER = Logger.getLogger(SmtpUtil.class);

    private static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";

    private Properties smtpConfig;

    public SmtpUtil(Properties smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public void sendEmail(String subject, String content, InternetAddress[] emailTo, InternetAddress[] emailCc) throws MessagingException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("About to send email notification");
            LOGGER.info("Email TO: " + Arrays.asList(emailTo));
            LOGGER.info("Email CC: " + Arrays.asList(emailCc));
            LOGGER.info("Subject: " + subject);
            LOGGER.info("Content:\n" + content);
        }

        final Properties props = new Properties(smtpConfig);
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                final String name = props.getProperty("mail.smtp.auth.user");
                final String passwd = props.getProperty("mail.smtp.auth.passwd");
                return new PasswordAuthentication(name, passwd);
            }
        });

        Message message = new MimeMessage(session);
        message.setHeader("X-Mailer", "smtpsend");
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(props.getProperty("mail.from"), true));
        message.setRecipients(Message.RecipientType.TO, emailTo);
        message.setRecipients(Message.RecipientType.CC, emailCc);
        message.setSubject(subject);
        message.setContent(content, CONTENT_TYPE_TEXT_PLAIN);

        Transport.send(message);
    }
}
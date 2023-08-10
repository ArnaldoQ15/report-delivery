package com.report.delivery.config.email;

import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.config.report.ReportData;
import com.report.delivery.dto.EmailDTO;
import jakarta.annotation.Nullable;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.codec.CharEncoding.UTF_8;
import static org.springframework.util.StringUtils.cleanPath;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailProvider {

    private final EmailProperties emailProperties;
    private static final Boolean IS_HTML = FALSE;

    @Async
    public void sendEmail(final EmailDTO emailDTO, @Nullable final ReportData[] attachments) throws BadRequestException {
        final boolean hasAttachments = nonNull(attachments) && attachments.length > 0;
        final JavaMailSender emailSender = configure();
        final MimeMessage message = emailSender.createMimeMessage();

        try {
            final MimeMessageHelper helper = new MimeMessageHelper(message, hasAttachments, UTF_8);

            if (hasAttachments) {
                addFiles(helper, attachments);
            }

            final MimeMessage content = this.createBody(message, helper, emailDTO.getTo(),
                    emailDTO.getSubject(), emailDTO.getBody());
            emailSender.send(content);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw new BadRequestException("error.email");
        }
    }

    private void addFiles(final MimeMessageHelper helper, final ReportData[] attachments) throws MessagingException {
        for (final ReportData attachment : attachments) {
            final String fileName = cleanPath(requireNonNull(attachment.getName()));
            final InputStreamSource source = new ByteArrayResource(attachment.getData());
            helper.addAttachment(fileName, source);
        }
    }

    private MimeMessage createBody(final MimeMessage message, final MimeMessageHelper helper, final List<String> to,
                                   final String subject, final String body) throws MessagingException {
        helper.setTo(to.toArray(new String[0]));
        helper.setText(body, IS_HTML);
        helper.setFrom(emailProperties.getUsername());
        helper.setSubject(subject);

        return message;
    }

    private JavaMailSender configure() {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(emailProperties.getHost());
        mailSender.setPort(emailProperties.getPort());
        mailSender.setUsername(emailProperties.getUsername());
        mailSender.setPassword(emailProperties.getPassword());
        mailSender.setDefaultEncoding("UTF-8");

        final Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailProperties.getProtocol().toLowerCase());
        props.put("mail.smtp.auth", TRUE);
        props.put("mail.smtp.starttls.enable", TRUE);
        props.put("mail.debug", emailProperties.getIsDebug());
        return mailSender;
    }

}
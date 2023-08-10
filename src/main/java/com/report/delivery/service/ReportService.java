package com.report.delivery.service;

import com.report.delivery.config.email.EmailProvider;
import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.config.report.ReportData;
import com.report.delivery.config.report.ReportProvider;
import com.report.delivery.dto.EmailDTO;
import com.report.delivery.entity.Delivery;
import com.report.delivery.entity.Receiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.report.delivery.config.report.ReportName.DELIVERY;
import static com.report.delivery.config.report.ReportType.PDF;
import static com.report.delivery.util.Message.getMessage;
import static com.report.delivery.util.QRCodeUtils.generateQrCode;
import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ReportService implements IReportService {

    private final ReportProvider reportProvider;
    private final IDeliveryService deliveryService;
    private final EmailProvider emailProvider;
    private static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm";
    private static final String PATTERN_DELIVERY_NUMBER = "%06d";
    private static final String QR_CODE_LINK = "https://mail.google.com/mail/?view=cm&source=mailto&to=arnaldo.s.fagundes@gmail.com";

    public ReportData generateRandomReport() throws BadRequestException {
        final Delivery delivery = deliveryService.getRandomDelivery();
        final Map<String, Object> parameters = getParameters(delivery);
        final ReportData report = reportProvider.getReportData(DELIVERY.getDescription(), parameters,
                PDF, singletonList(delivery));
        final EmailDTO emailDto = getEmailDto(delivery, parameters);

        emailProvider.sendEmail(emailDto, new ReportData[] {report});
        return report;
    }

    private Map<String, Object> getParameters(final Delivery delivery) throws BadRequestException {
        final LocalDateTime dateTime = now();
        final byte[] qrCode = generateQrCode(QR_CODE_LINK, "png");
        final Map<String, Object> parameters = new HashMap<>();

        parameters.put("DATE_TIME_GENERATED", dateTime.format(ofPattern(PATTERN_DATE_TIME)));
        parameters.put("QR_CODE", reportProvider.getImageFromByteArray(qrCode));
        parameters.put("QR_CODE_LINK", QR_CODE_LINK);
        parameters.put("DELIVERY_STATUS", delivery.getStatus().getDescription());
        parameters.put("DELIVERY_NUMBER", format(PATTERN_DELIVERY_NUMBER, delivery.getId()));

        return parameters;
    }

    private EmailDTO getEmailDto(final Delivery delivery, final Map<String, Object> parameters) throws BadRequestException {
        final String deliveryNumber = parameters.get("DELIVERY_NUMBER").toString();
        final String receiverEmail =
                ofNullable(delivery.getReceiver())
                        .map(Receiver::getEmail)
                        .orElseThrow(() -> new BadRequestException("error.email.receiver-not-found"));

        return EmailDTO.builder()
                .to(singletonList(receiverEmail))
                .subject(getMessage("email.subject", deliveryNumber))
                .body(getMessage("email.body", deliveryNumber))
                .build();
    }

}
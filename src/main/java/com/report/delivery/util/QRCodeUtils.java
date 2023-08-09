package com.report.delivery.util;

import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.report.delivery.config.exception.BadRequestException;
import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import static com.google.zxing.BarcodeFormat.QR_CODE;
import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

@Slf4j
@NoArgsConstructor(access=PRIVATE)
public class QRCodeUtils {

    public static byte[] gerarQRCode(final String data, final String extension,
                                     @Nullable final Integer size) throws BadRequestException {
        final String charset = "UTF-8";
        final Map<EncodeHintType, Object> hashMap = new HashMap<>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hashMap.put(EncodeHintType.MARGIN, 1);

        try {
            final BitMatrix matrix =
                    new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
                            QR_CODE, getSize(size), getSize(size), hashMap);

            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, extension, byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        } catch (final Exception e) {
            throw new BadRequestException("error.generateQrCode");
        }
    }

    private static Integer getSize(final Integer size) {
        return isNull(size) ? 400 : size;
    }

    public static byte[] gerarQRCode(final String destino, final String extension) throws BadRequestException {
        return gerarQRCode(destino, extension, null);
    }

}
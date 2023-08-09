package com.report.delivery.config.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static com.report.delivery.config.report.ReportType.PDF;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static org.springframework.http.MediaType.APPLICATION_PDF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {

    private byte[] data;
    private String name;
    private ReportType type;

    public ResponseEntity<Resource> toResponseEntity() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(PDF.equals(type) ? APPLICATION_PDF : APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }

}
package com.report.delivery.config.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportType {

    PDF("pdf");

    private final String extension;

}
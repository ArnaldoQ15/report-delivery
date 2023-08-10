package com.report.delivery.config.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportName {

    DELIVERY("delivery");

    private final String description;

}
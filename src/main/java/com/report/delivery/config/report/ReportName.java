package com.report.delivery.config.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportName {

    ORDER_STATUS("order_status");

    private final String description;

}
package com.report.delivery.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumDeliveryStatus {

    PENDING("Pending"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String description;

}
package com.report.delivery.service;


import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.entity.Delivery;

public interface IDeliveryService {

    Delivery getRandomDelivery() throws BadRequestException;

}
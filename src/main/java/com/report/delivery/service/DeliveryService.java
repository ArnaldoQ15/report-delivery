package com.report.delivery.service;

import com.report.delivery.config.exception.BadRequestException;
import com.report.delivery.entity.Delivery;
import com.report.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DeliveryService implements IDeliveryService {

    private final DeliveryRepository deliveryRepository;

    public Delivery getRandomDelivery() throws BadRequestException {
        final Random random = new Random();
        final List<Long> deliveriesIds = deliveryRepository.findAllIds();
        final Long randomId = deliveriesIds.get(random.nextInt(deliveriesIds.size()));
        return deliveryRepository.findById(randomId)
                .orElseThrow(() -> new BadRequestException("delivery.not-found"));
    }

}
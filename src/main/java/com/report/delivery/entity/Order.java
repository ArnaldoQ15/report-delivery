package com.report.delivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product", nullable = false)
    private String product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receiver", nullable = false)
    private Receiver receiver;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "delivery_fee", nullable = false)
    private BigDecimal deliveryFee;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

}
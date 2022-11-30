package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "paymentdetails")
@Table(name ="paymentdetails")
public class PaymentDetails {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPaymentDetails;

    @Column(name="status")
    private String status;

    @Column(name="provider")
    private String provider;

    @Column(name="amount")
    private String amount;

    @Column(name="created_at")
    private String created_at;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "methodpay_id")
    private MethodPay methodpay;


}

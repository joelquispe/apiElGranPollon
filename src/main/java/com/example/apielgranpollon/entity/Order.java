package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "orders")
@Table(name ="orders")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="price")
    private String price;

    @Column(name="estatus")
    private String estatus;

    @Column(name="dateDelivery")
    private String dateDelivery;

    @Column(name="dateOrder")
    private String dateOrder;

    @Column(name="destinity")
    private String destinity;

    @ManyToOne
    @JoinColumn(name = "orderstatus_id")
    private OrderStatus orderStatus;

}
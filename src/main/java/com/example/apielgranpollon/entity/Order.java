package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity(name = "orders")
@Table(name ="orders")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="total")
    private String total;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="orderDate")
    private Date orderDate;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
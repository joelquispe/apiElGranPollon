package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "orderdetails")
@Table(name ="orderdetails")
public class OrdenDetails {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="total")
    private Double total;
    @Column(name="quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "plates_id")
    private Plates plates;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

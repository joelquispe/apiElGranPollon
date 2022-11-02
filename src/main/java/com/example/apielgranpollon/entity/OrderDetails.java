package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "orderdetails")
@Table(name ="orderdetails")
public class OrderDetails {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="total")
    private Double total;
    @Column(name="quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "motorized_id")
    private Motorized motorized;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

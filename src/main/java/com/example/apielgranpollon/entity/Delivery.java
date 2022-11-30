package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "delivery")
@Table(name ="delivery")
public class Delivery {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDelivery;

    @Column(name="quantity")
    private String quantity;

    @Column(name="created_at")
    private String created_at;

    @ManyToOne
    @JoinColumn(name = "motorized_id")
    private Motorized motorized;

    @ManyToOne
    @JoinColumn(name = "lineaorden_id")
    private LineaOrden lineaOrden;


}

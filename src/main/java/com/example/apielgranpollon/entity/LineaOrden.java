package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "lineadeorden")
@Table(name ="lineadeorden")
public class LineaOrden {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idLineadeOrden;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Order order;

}

package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "cart")
@Table(name ="cart")
public class Cart {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="created_ad")
    private String created_ad;

    @Column(name="total")
    private String total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}

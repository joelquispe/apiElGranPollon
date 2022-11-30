package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "address")
@Table(name ="address")
public class Address {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAddress;

    @Column(name="address")
    private String address;

    @Column(name="reference")
    private String reference;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="number")
    private String number;

    @Column(name="latitude")
    private String latitude;

    @Column(name="longitude")
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}

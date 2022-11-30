package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "creditcard")
@Table(name ="creditcard")
public class CreditCard {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCreditCard;
    @Column(name="cc_num")
    private String cc_num;

    @Column(name="expire_date")
    private String expire_date;

    @Column(name="number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}

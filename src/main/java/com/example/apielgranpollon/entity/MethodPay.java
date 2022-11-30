package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "methodpay")
@Table(name ="methodpay")
public class MethodPay {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMethodpay;

    @Column(name="name")
    private String name;

}

package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "motorized")
@Table(name = "motorized")
public class Motorized implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="dni")
    private String dni;
    @Column(name="phone")
    private String phone;
    @Column(name="placa")
    private String placa;
    @Column(name="soat")
    private String soat;
    @Column(name="age")
    private String age;

    @ManyToOne
    @JoinColumn(name = "motorizedStatus_id")
    private MotorizedStatus motorizedStatus;

}

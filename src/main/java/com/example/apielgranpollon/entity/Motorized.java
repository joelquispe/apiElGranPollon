package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
    @Column(name = "email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="dni")
    private String dni;
    @Column(name="phone")
    private String phone;
    @Column(name="placa")
    private String placa;
    @Column(name="soat")
    private String soat;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="date_of_Birth")
    private Date datebirth;



    @ManyToOne
    @JoinColumn(name = "motorizedStatus_id")
    private MotorizedStatus motorizedStatus;



}

package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity(name = "cliente")
@Table(name ="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="dateofbirth")
    private Date dateofbirth;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;


    @Column(name="phone")
    private String phone;



}

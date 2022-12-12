package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "cliente")
@Table(name ="cliente")
public class Cliente {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso= DateTimeFormat.ISO.DATE)
    @Column(name="dateofbirth")
    private LocalDate dateofbirth;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;


    @Column(name="phone")
    private String phone;

    @Column(name="fcmtoken")
    private String fcmtoken;



}

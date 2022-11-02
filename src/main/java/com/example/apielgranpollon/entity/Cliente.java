package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
    @Column(name="date_of_Birth")
    private Date dateOfBirth;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;
    @Column(name="district")
    private String district;
    @Column(name="address")
    private String address;



}

package com.example.apielgranpollon.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name="age")
    private String age;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="dni")
    private String dni;
    @Column(name="phone")
    private String phone;

}

package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "employe")
@Table(name = "employe")
public class Employe implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="phone")
    private String phone;
    @Column(name="dni")
    private String dni;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="datebirth")
    private String datebirth;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

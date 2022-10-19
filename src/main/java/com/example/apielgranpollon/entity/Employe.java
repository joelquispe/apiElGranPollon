package com.example.apielgranpollon.entity;

import lombok.Data;

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
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

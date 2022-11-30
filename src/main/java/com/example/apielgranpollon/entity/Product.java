package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "product")
@Table(name ="product")
public class Product implements Serializable {
        private static final long serialVersionUID=1L;
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="price")
        private double price;
        @Column(name="stock")
        private  int stock;
        @Column(name="description")
        private  String description;
        @Column(name = "status")
        private boolean status;
        @Column(name = "image")
        private String image;

        @ManyToOne
        @JoinColumn(name = "categoria_id")
        private Category category;



}


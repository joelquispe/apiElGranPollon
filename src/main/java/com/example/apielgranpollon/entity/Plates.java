package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "plates")
@Table(name ="plates")
public class Plates implements Serializable {
        private static final long serialVersionUID=1L;
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name="price")
        private String price;
        @Column(name="stock")
        private  String stock;
        @Column(name="description")
        private  String description;
        @Column(name = "status")
        private String status;

        @ManyToOne
        @JoinColumn(name = "categoria_id")
        private Category category;

}


package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity(name = "shoppingcart")
@Table(name ="shoppingcart")
public class ShoppingCart {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="amount")
    private String amount;
    @Column(name="precio")
    private String precio;

    @ManyToOne
    @JoinColumn(name = "plates_id")
    private Plates plates;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}

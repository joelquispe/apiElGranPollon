package com.example.apielgranpollon.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "cart")
@Table(name ="cart")
public class Cart {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="total")
    private String total;

    @Column(name="isInOrder")
    private Boolean isInOrder = false;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


}

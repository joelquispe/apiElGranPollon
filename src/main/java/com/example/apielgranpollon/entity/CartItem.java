package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "cartItem")
@Table(name ="cartItem")
public class CartItem {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCartItem;

    @Column(name="quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}

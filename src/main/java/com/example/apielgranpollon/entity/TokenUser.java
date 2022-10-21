package com.example.apielgranpollon.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tokenuser")
@Table(name = "tokenuser")
public class TokenUser {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token")
    private String token;

    @OneToOne(mappedBy = "token")
    private User user;
}

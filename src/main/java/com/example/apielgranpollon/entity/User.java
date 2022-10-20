package com.example.apielgranpollon.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue()
    private Integer id;
    private String username;
    private String password;
    private String token;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}

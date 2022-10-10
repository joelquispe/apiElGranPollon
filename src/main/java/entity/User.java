package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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


}

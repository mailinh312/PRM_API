package com.app.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String username;

    @Column(name = "password")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String password;

    @Column(name = "address")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String address;

    @Column(name = "phone")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

}
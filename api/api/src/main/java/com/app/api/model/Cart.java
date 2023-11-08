package com.app.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_date", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Instant orderDate = Instant.now();

    @Column(name = "address")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String address;

    @Column(name = "phone", length = 20)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String phone;

    @Column(name = "note")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String note;

}
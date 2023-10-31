package com.app.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "cart_detail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "quantity")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer quantity;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Integer price;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
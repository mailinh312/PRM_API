package com.app.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_name", nullable = false)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String productName;

    @Column(name = "description", length = 500)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String description;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double price;

    @Column(name = "image_url")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String imageUrl;

    @Column(name = "quantity")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(int id, String name, double price, String img) {
        this.id = id;
        this.productName = name;
        this.price = price;
        this.imageUrl = img;
    }
}
package com.example.exam_module4.controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;

    @NotBlank(message = "Không để trống")
    private String name;

    private long price;

    private String status;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    private Category id_category_sp;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getId_category_sp() {
        return id_category_sp;
    }

    public void setId_category_sp(Category id_category_sp) {
        this.id_category_sp = id_category_sp;
    }
}

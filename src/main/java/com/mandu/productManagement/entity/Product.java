package com.mandu.productManagement.entity;



import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    //This is to auto generate the id. We need to define a strategy for the generation of the id
    //The strategy GenerationType.IDENTITY specifies that the id will be auto generated as per database feature
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id") // Map to the correct column name
    private Integer productId; // Rename the field to match the column name
    private String name;
    private String type;
    private String place;
    private int warranty;

    public Product() {
    }

    public Product(String name, String type, String place, int warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Objects.equals(Id, product.Id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(Id);
//    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}

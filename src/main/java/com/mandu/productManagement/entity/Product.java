package com.mandu.productManagement.entity;



import jakarta.persistence.*;
import lombok.Data;
//import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

//@XmlRootElement
@Entity
@Table(name = "product")
//@Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Data
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

}

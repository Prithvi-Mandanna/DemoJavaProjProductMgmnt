package com.mandu.productManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    //Commenting as we do not need a data layer OR ProductDb clsss when working with Spring JPA
    //ProductDbOrm db = new ProductDbOrm();
    @Autowired
    ProductDb db;
    List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        db.save(p);
        //products.add(p);
    }

    public List<Product> getAllProducts() {
        return db.findAll();
        //return db.getAllProductsFromDB();
    }

//    public void getOneProduct(String productName) {
//        for (Product product : products){
//            if (product.getName() == productName){
//                System.out.println(product);
//            }
//        }
//    }

    public void getOneProduct(String productName) {
        products = db.findByName(productName);
//        for (Product product : products){
//            if (product.getName().equals(productName)){
//                return product;
//                            }
//        }
        for (Product product : products){
            System.out.println(product);
        }
    }

    public void getProductsByLocation(String productLocation) {

        List<Product> productsByPlace = db.findByPlace(productLocation);


//        for (Product product: products){
//            if (product.getPlace().equals(productLocation)){
//                productsByPlace.add(product);
//            }
//        }

        for (Product p: productsByPlace){
            System.out.println(p);
        }
        if (productsByPlace.isEmpty()){
            System.out.println("There are no products in " + productLocation);
        }
    }


    public void getProductsOutOfWarranty(int warrantyYear) {
    List<Product> prodsOutOfWarranty = db.findByWarrantyLessThan(warrantyYear);
        System.out.println("Products Out of Warranty using JPA are as below");
    for (Product product: prodsOutOfWarranty){
        System.out.println(product);
    }

        //Below code is written using Stream API function
        System.out.println("Products Out of Warranty using Stream API as below");
    products.stream()
            .filter(n -> n.getWarranty() < warrantyYear)
            .forEach(System.out::println);


//        for (Product product : products){
//            if (product.getWarranty() < warrantyYear){
//                prodsOutOfWarranty.add(product);
//            }
//        }
//        prodsOutOfWarranty.forEach(p-> System.out.println(p));
//
//        if (prodsOutOfWarranty.isEmpty()){
//            System.out.println("There are no products out of warranty");
//        }

    }
}

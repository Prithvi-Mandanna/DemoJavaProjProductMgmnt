package com.mandu.productManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public Product getOneProduct(String productName) {
        products = db.findAll();
        for (Product product : products){
            if (product.getName().equals(productName)){
                return product;
                            }
        }
        return null;
    }

    public void getProductsByLocation(String productLocation) {

        List<Product> productsByPlace = new ArrayList<>();


        for (Product product: products){
            if (product.getPlace().equals(productLocation)){
                productsByPlace.add(product);
            }
        }

        for (Product p: productsByPlace){
            System.out.println(p);
        }
        if (productsByPlace.isEmpty()){
            System.out.println("There are no products in " + productLocation);
        }
    }


    public void getProductsOutOfWarranty(int warrantyYear) {
    //List<Product> prodsOutOfWarranty = new ArrayList<>();

        //Below code is written using Stream API function
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

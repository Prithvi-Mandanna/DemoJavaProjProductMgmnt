package com.mandu.productManagement;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductService {

    ProductDb db = new ProductDb();
    List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {


        db.save(p);
        //products.add(p);
    }

    public List<Product> getAllProducts() {
        return products;

    }

//    public void getOneProduct(String productName) {
//        for (Product product : products){
//            if (product.getName() == productName){
//                System.out.println(product);
//            }
//        }
//    }

    public Product getOneProduct(String productName) {
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

package com.mandu.productManagement;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    ProductDb db = new ProductDb();
    List<Product> products = new ArrayList<>();
    public void addProduct(Product p) {
        db.save(p);
        //products.add(p);
    }

    public List<Product> getAllProducts() {
        return db.getAllProductsFromDB();
    }

//    public void getOneProduct(String productName) {
//        for (Product product : products){
//            if (product.getName() == productName){
//                System.out.println(product);
//            }
//        }
//    }

    public Product getOneProduct(String productName) {
        products = db.getAllProductsFromDB();
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

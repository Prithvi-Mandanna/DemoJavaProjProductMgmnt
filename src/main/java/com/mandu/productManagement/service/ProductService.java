package com.mandu.productManagement.service;

import com.mandu.productManagement.entity.Product;
import com.mandu.productManagement.entity.ProductAllocation;
import com.mandu.productManagement.repo.EmployeeDb;
import com.mandu.productManagement.repo.ProductAllocationDb;
import com.mandu.productManagement.repo.ProductDb;
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

    @Autowired
    EmployeeDb employeeDb;

    @Autowired
    ProductAllocationDb productAllocationDb;

    List<Product> products = new ArrayList<>();
    public Product addProduct(Product p) {
        return db.save(p);
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


    public void getProductsAllocatedToEmployee(int i) {

        List<ProductAllocation> productsAllocatedToEmployee = productAllocationDb.findByEmployeeId(i);
//        Optional<ProductAllocation> productsAllocatedToEmployee = productAllocationDb.findByEmployeeId(i);
//        if (productsAllocatedToEmployee.isPresent()){
//            return productsAllocatedToEmployee.get();
//        } else {
//            System.out.println("There are no products allocated to employee with id " + i);
//        }
        for (ProductAllocation product: productsAllocatedToEmployee){
            System.out.println(product.getProduct());
        }
        if (productsAllocatedToEmployee.isEmpty()){
            System.out.println("There are no products allocated to employee with id " + i);
        }
    }

    public List<ProductAllocation> getAllProductAllocations() {

        List<ProductAllocation> allProductAllocations = productAllocationDb.findAll();
        return allProductAllocations;
    }

    public void getTop5ProductAllocations(){
        List<ProductAllocation> allocations = new ArrayList<>();
        allocations = productAllocationDb.findTop5ByOrderByProductAllocationIdDesc();
        for (ProductAllocation top5Allocations: allocations){
            System.out.println(top5Allocations.getEmployee());
            System.out.println(top5Allocations.getProduct());
            System.out.println();
        }
    }

    public ProductAllocation allocateProductToEmployee(int employeeId, int productId) {

        System.out.println("Allocating product with id " + productId + " to employee with id " + employeeId);
        ProductAllocation allocation = new ProductAllocation();
        allocation.setEmployee(employeeDb.findById(employeeId).get());
        allocation.setProduct(db.findById(productId).get());
        allocation.setAllocatedAt(java.time.LocalDateTime.now());
        return productAllocationDb.save(allocation);
    }

    public List<Product> getProductsByType(String productType) {
        return db.findByType(productType);
    }

    public Product getProductById(Integer product_id) {
        //getting product by productId
        return db.findById(product_id).get();
        //return db.findByProductId(product_id);
    }
}

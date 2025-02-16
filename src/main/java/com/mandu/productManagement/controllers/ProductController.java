package com.mandu.productManagement.controllers;

import com.mandu.productManagement.entity.Product;
import com.mandu.productManagement.entity.ProductAllocation;
import com.mandu.productManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    //@GetMapping(path="/products",produces = {"application/xml"})
    @GetMapping(path="/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path="/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Integer id){
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    //get products by type
    @GetMapping(path="/products/type/{type}")
    public List<Product> getProductsByType(@PathVariable String type){
        return productService.getProductsByType(type);
    }

    @PostMapping(path="/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    @GetMapping(path="/products/allocations")
    public List<ProductAllocation> getAllProductAllocations(){
        return productService.getAllProductAllocations();
    }
}

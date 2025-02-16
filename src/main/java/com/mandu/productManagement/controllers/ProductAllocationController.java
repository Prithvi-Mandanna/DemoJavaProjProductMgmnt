package com.mandu.productManagement.controllers;

import com.mandu.productManagement.entity.Product;
import com.mandu.productManagement.entity.ProductAllocation;
import com.mandu.productManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductAllocationController {
    @Autowired
    ProductService productService;

    @PostMapping(path="/allocation")
    public ResponseEntity<ProductAllocation> allocateProductToEmployee(
            @RequestParam Integer employeeId,
            @RequestParam Integer productId)
    {
        ProductAllocation productAllocation = productService.allocateProductToEmployee(employeeId, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(productAllocation);
    }

}

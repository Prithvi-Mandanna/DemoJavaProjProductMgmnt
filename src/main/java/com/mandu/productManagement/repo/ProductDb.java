package com.mandu.productManagement.repo;

import com.mandu.productManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDb extends JpaRepository<Product, Integer> {

    List<Product> findByPlace(String place);

    //@Query("select p from product p where p.warranty < ?1")
    List<Product> findByWarrantyLessThan(int warranty);
    List<Product> findByName(String name);



}

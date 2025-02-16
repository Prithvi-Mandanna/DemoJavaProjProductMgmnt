package com.mandu.productManagement.repo;

import com.mandu.productManagement.entity.ProductAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAllocationDb extends JpaRepository<ProductAllocation, Integer> {

    List<ProductAllocation> findByEmployeeId(int i);
    //custom method to find top 5 records ordered by product_allocation_id desc
    List<ProductAllocation> findTop5ByOrderByProductAllocationIdDesc();
    //findTop5ByOrderByProductAllocationIdDesc()
}

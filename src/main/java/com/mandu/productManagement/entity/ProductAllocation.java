package com.mandu.productManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_allocation")
public class ProductAllocation {
    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_allocation_id")
    private Integer productAllocationId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "allocated_at", updatable = false)
    private LocalDateTime allocatedAt;

    public ProductAllocation(Integer id, Employee employee, Product product, LocalDateTime allocatedAt) {
        this.productAllocationId = id;
        this.employee = employee;
        this.product = product;
        this.allocatedAt = allocatedAt;
    }

    public ProductAllocation() {
    }

    public Integer getId() {
        return productAllocationId;
    }

    public void setId(Integer id) {
        this.productAllocationId = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getAllocatedAt() {
        return allocatedAt;
    }

    public void setAllocatedAt(LocalDateTime allocatedAt) {
        this.allocatedAt = allocatedAt;
    }
}

package com.mandu.productManagement;

import com.mandu.productManagement.entity.Product;
import com.mandu.productManagement.service.EmployeeService;
import com.mandu.productManagement.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {

		//Product p = new Product("Laptop", "Electronics", "Kathmandu", 1);
		//ProductService service; = new ProductService();

        ApplicationContext context = SpringApplication.run(Main.class, args);
		ProductService service = context.getBean(ProductService.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);

//		service.addProduct(new Product("Lamborghini", "Automobile", "Kathmandu", 2003));
//		service.addProduct(new Product("Mobile", "Electronics", "Madikeri", 2005));
//		service.addProduct(new Product("Shoes", "Fashion", "Bangalore", 2025));
//		service.addProduct(new Product("Shirt", "Fashion", "Madikeri", 2003));
//		service.addProduct(new Product("Bag", "Fashion", "Bangalore", 2005));
//		service.addProduct(new Product("Watch", "Fashion", "Kathmandu", 2003));

		List<Product> products = service.getAllProducts();
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println("-------------------");
		//This is to get the location of one product
		System.out.println("Details if one product is:");
		service.getOneProduct("Laptop");

		//This is to get the products by Location
		System.out.println("Products by Location Bangalore are:");
		service.getProductsByLocation("Madikeri");

		//This is to get the products that are out of warranty
		System.out.println("Products that are out of warranty are:");
		service.getProductsOutOfWarranty(2005);

		//Employee data
		System.out.println("------------Employee Data------------");
		employeeService.getAllEmployees();

		//service.allocateProductToEmployee(3,117);

		//Code to get products allocated to an employee
		System.out.println("Products allocated to an employee are:");
		service.getTop5ProductAllocations();
		//service.getAllProductAllocations();
		service.getProductsAllocatedToEmployee(1);

	}

}

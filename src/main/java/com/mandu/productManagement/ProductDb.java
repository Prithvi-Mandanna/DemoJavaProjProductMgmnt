package com.mandu.productManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDb {
    private Connection con = null;
    public ProductDb() {

        String url = "jdbc:mysql://localhost:3306/springjdbc";
        String username = "root";
        String password = "Mandu";
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getType());
            ps.setString(3, product.getPlace());
            ps.setInt(4, product.getWarranty());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllProductsFromDB() {
        List<Product> products = new ArrayList<>();
        String query = "Select * from product";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            //code to return the result set
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String place = rs.getString("place");
                int warranty = rs.getInt("warranty");
                Product product = new Product(name, type, place, warranty);
                products.add(product);
            }
            //ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

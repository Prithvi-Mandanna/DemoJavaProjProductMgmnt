package com.mandu.productManagement;

import java.sql.*;

public class ProductDb {
    Connection con = null;
    public ProductDb() {

        //adding a new MySQL database connection
//        static {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
        //comment to test git - to be removed
        String url = "jdbc:mysql://localhost:3306/springjdbc";
        String username = "Mandu";
        String password = "Mandu";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        Connection con;

//        {
//            try {
//                con = DriverManager.getConnection(url, username, password);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }




    public void save(Product product) {
        String query = "insert into product values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(1, product.getName());
            ps.setString(2, product.getType());
            ps.setString(3, product.getPlace());
            ps.setInt(4, product.getWarranty());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

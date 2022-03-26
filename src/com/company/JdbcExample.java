package com.company;

import java.sql.*;

public class JdbcExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_example";
    static final String USER = "root";
    static final String PASS = "111111";
    static final String QUERY = "SELECT id, age FROM Employees";

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(QUERY);

            while(rs.next()){
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("AGE : " + rs.getInt("age"));
                System.out.println("NAME : " + rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

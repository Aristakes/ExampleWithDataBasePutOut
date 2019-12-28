package com.company;

import java.sql.*;
import java.util.Scanner;

public class DbConnect {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbUserName = "root";
    private String dbPassword = "aris";


    public DbConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e);
        }
    }

    public void getData(){
        try {
            connection = DriverManager.getConnection(url , dbUserName , dbPassword);
            statement = connection.createStatement();
            String query = "select * from test_schema.test_table";
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("UserName : "+resultSet.getString("userName"));
                System.out.println("Password : " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error getData method " + e);
        }
    }

    public void addData(String putName , String putPassword){
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema" ,
                    dbUserName , dbPassword);

            String query = "INSERT INTO test_schema.test_table(userName, password) VALUES (? , ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, putName);
            preparedStatement.setString(2, putPassword);

            preparedStatement.executeUpdate();
            connection.close();

        }catch (Exception e){
            System.out.println("Error addDataMethod " + e);
        }
    }

    public void deleteData(int del){
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema" , dbUserName , dbPassword);

            String query = "DELETE FROM test_schema.test_table WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1 , del);

            statement.executeUpdate();
            connection.close();


        }catch (Exception e ){
            System.out.println("Error deleteData method " + e);
        }
    }


}

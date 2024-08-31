package BankingSystem;

import java.sql.*;
import java.util.Scanner;

public class User {
    private Connection connection;
    private Scanner scanner;

    public User(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
    public void register(){
        scanner.nextLine();
        System.out.print("Enter Your Full name: ");
        String full_name = scanner.nextLine();
        System.out.print("Enter you email: ");
        String email = scanner.nextLine();
        System.out.print("Set Your Password: ");
        String password = scanner.nextLine();

        if(user_exist(email)){
            System.out.println("User already exits for this email Address");
            return;
        }
        String register_query = "INSERT INTO user(full_name,email,password) VALUES(?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(register_query);
            preparedStatement.setString(1,full_name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Registration Successful");
            }
            else{
                System.out.println("Registration Failed!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String login(){
        scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String login_query = "SELECT * FROM user Where email = ? AND password = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(login_query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return  email;
            }
            else {
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  null;
    }

    public boolean user_exist(String email){
        String query = "SELECT * FROM user Where email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

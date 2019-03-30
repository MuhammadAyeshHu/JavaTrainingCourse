package database.Main;

import database.DAO.UserDAO;
import database.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = in.nextLine();

        System.out.println("Enter password: ");
        String password = in.nextLine();

        User user = UserDAO.authenticate(username,password);

        if(user == null) {
            System.out.println("Authentication failed");
        } else {
            System.out.println("Logged in successfully");
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getEmail());
            System.out.println(user.getPhoneNumber());
        }
    }
}
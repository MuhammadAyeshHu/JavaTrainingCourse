package classes;

import java.util.Scanner;

public class AccountTest {
    /**
     * main is static method
     * you can call it without first creating an object of the class
     */
    public static void main(String[] args) {
        /*
         * Instead of import Scanner class we can use this:
         * java.util.Scanner input = new java.util.Scanner(System.in);
         */
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account();

        System.out.println(myAccount.getName());
        System.out.println(myAccount.getBalance());

        System.out.println("please enter your name: ");
        String userName = input.next();
        System.out.println("Please enter your balance: ");
        double balance = input.nextDouble();

        myAccount.setName(userName);
        myAccount.setBalance(balance);

        System.out.println(myAccount.getName());
        System.out.println(myAccount.getBalance());

        myAccount.deposit(500);
        myAccount.withdraw(200);

        System.out.println(myAccount.getBalance());
    }
}

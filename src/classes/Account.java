package classes;

public class Account {
    private String name;
    private double balance;

    // No-access modifier - this is a package private method
    String getName() {
        return name;
    }

    /**
     * #Validation:
     * set methods can be programmed to *validate* their arguments
     * and reject any attempts to set the data to bad values
     * ^ means begin of a string
     * [a-zA-Z] means any letter in range a-z or A-Z
     * $ means end of a string
     */
    public void setName(String name) {
        if (name.matches("^[a-zA-Z]+$"))
            this.name = name;
        else {
            System.out.println("Name must contain only letters from a-z or A-Z");
        }
    }

    protected double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0.0)
            this.balance = balance;
        else {
            System.out.println("Balance cannot be less than 0");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Amount " + amount + " has been transferred to your account.");
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println("Amount " + amount + " has been withdrawn from your account.");
    }
}

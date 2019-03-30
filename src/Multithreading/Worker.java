package Multithreading;

public class Worker extends Thread {

    BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <100 ; i++) {
            account.deposit(10);
        }
    }
}
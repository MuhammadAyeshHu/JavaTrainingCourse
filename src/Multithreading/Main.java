package Multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(500);

        Worker worker1 = new Worker(account);
        Worker worker2 = new Worker(account);

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        System.out.println(account.getBalance());
    }
}
package Multithreading;

public class TestJob {

    public static void main(String[] args) {
        Job job1 = new Job(1);
        Job job2 = new Job(2);

        Thread t1 = new Thread(job1);
        Thread t2  = new Thread(job2);

        t1.start();
        t2.start();
    }
}
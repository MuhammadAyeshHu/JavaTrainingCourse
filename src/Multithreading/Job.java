package Multithreading;

import static java.lang.Thread.sleep;

public class Job implements Runnable {

    private int jobNum;

    public Job(int jobNum) {
        this.jobNum = jobNum;
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(jobNum);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // System.out.println("Job running " + jobNum);
    }
}
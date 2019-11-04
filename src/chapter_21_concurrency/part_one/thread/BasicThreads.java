package chapter_21_concurrency.part_one.thread;

import chapter_21_concurrency.part_one.LiftOff;

public class BasicThreads {

    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();

        System.out.println("Waiting for LiftOff");
    }
}

package chapter_21_concurrency.part_one.thread;

import chapter_21_concurrency.part_one.LiftOff;

public class MainThread {

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}

package chapter_21_concurrency.part_one.callable;

import java.util.concurrent.Callable;

public class CallableLiftOff implements Callable<String> {

    private static int taskCounter = 0;
    private final int id = taskCounter++;

    private int countDown = 10;

    public CallableLiftOff() {
    }

    public CallableLiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(CallableLiftOff!!)";
    }

    @Override
    public String call() throws Exception {
        return status();
    }
}

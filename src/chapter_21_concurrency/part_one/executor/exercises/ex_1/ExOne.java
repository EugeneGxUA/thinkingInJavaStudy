package chapter_21_concurrency.part_one.executor.exercises.ex_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExOne implements Runnable {

    private static int taskCounter;
    private final int id = taskCounter++;

    @Override
    public void run() {
        System.out.println("Message from " + id + " Thread, yield one");
        Thread.yield();
        System.out.println("Message from " + id + " Thread, yield two");
        Thread.yield();
        System.out.println("Message from " + id + " Thread, yield three");
        Thread.yield();

        System.out.println("#" + id + " finish");
    }
}

class Executor {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            exec.execute(new ExOne());
        }
        exec.shutdown();
    }
}

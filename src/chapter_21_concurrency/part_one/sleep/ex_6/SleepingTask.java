package chapter_21_concurrency.part_one.sleep.ex_6;

import chapter_21_concurrency.part_one.LiftOff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

    @Override
    public void run() {

        Random random = new Random();

        try {
            int pause = random.nextInt(10) + 1;
            TimeUnit.SECONDS.sleep(pause);
            System.out.println("Pause -> " + pause);
        } catch (InterruptedException e) {
            System.err.println("Interrupted : " + e.getStackTrace());
        }
    }
}

class ExerciseExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}

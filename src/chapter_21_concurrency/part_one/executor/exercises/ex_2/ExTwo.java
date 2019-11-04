package chapter_21_concurrency.part_one.executor.exercises.ex_2;

import chapter_21_concurrency.part_one.thread.exercises.ex_2.FibonacciForExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExTwo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new FibonacciForExercise(i + 10));
        }
        exec.shutdown();
    }
}

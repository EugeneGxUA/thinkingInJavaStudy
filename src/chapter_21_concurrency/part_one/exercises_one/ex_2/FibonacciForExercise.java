package chapter_21_concurrency.part_one.exercises_one.ex_2;

import java.util.ArrayList;

public class FibonacciForExercise implements Runnable {

    private int n;

    private static int taskCounter = 0;
    private final int id = taskCounter++;

    public FibonacciForExercise(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        Fibonacci gen = new Fibonacci();
        ArrayList<Integer> fibArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fibArr.add(gen.next());
        }

        System.out.println("#" + id + " Thread : " + fibArr);
    }
}

class ExerciseExecutor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new FibonacciForExercise(i + 10)).start();
        }
    }
}

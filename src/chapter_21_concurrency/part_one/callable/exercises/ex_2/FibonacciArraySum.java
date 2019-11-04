package chapter_21_concurrency.part_one.callable.exercises.ex_2;

import chapter_21_concurrency.part_one.thread.exercises.ex_2.Fibonacci;

import java.util.ArrayList;
import java.util.concurrent.*;

public class FibonacciArraySum implements Callable<Integer> {
    private int n;

    private static int taskCounter = 0;
    private final int id = taskCounter++;

    public FibonacciArraySum(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        Fibonacci gen = new Fibonacci();
        Integer result = 0;
        for (int i = 0; i < n; i++) {
            result += gen.next();
        }

        return result;
    }
}

class FibonacciSumExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ArrayList<Future<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(executorService.submit(new FibonacciArraySum(i + 15)));
        }

        for (Future<Integer> el : result) {
            try {
                System.out.println(el.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
    }
}

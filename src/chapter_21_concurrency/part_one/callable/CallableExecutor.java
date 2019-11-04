package chapter_21_concurrency.part_one.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            results.add(exec.submit(new CallableLiftOff()));
        }

        for (Future<String> element : results) {
            try {
                System.out.println(element.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}

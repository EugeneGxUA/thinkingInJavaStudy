package chapter_21_concurrency.part_one.exercises_one.ex_1;

public class ExerciseOne implements Runnable {

    private static int taskCounter = 0;
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

class ExerciseExecutor {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ExerciseOne()).start();
        }
    }
}

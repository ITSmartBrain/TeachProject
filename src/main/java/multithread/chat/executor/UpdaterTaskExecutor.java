package multithread.chat.executor;

import multithread.chat.task.Task;

import java.util.Random;
import java.util.concurrent.*;

public class UpdaterTaskExecutor extends TaskExecutor {


    public UpdaterTaskExecutor(Task task, int period) {
        super(task, period);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while(true){
            FutureTask<String> futureTask = new FutureTask<>(task);

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(period));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(futureTask);
            try {
                String modifiedSmsText = futureTask.get();
                System.out.println("Изменение: Updater : "+modifiedSmsText);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

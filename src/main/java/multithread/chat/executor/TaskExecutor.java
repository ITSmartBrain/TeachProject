package multithread.chat.executor;

import multithread.chat.task.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class TaskExecutor implements Runnable {
    protected Task task;
    protected ExecutorService executorService;
    protected int secFrom;
    protected int secTo;
    protected int period;

    public TaskExecutor(Task task, int secFrom, int secTo) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.secFrom = secFrom;
        this.secTo = secTo;
    }

    public TaskExecutor(Task task, int period) {
        this.executorService = Executors.newSingleThreadExecutor();
        this.task = task;
        this.period = period;
    }



}

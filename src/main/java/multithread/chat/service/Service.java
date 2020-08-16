package multithread.chat.service;

import multithread.chat.data.Chat;
import multithread.chat.task.Task;
import multithread.chat.task.ReaderTask;
import multithread.chat.task.UpdaterTask;
import multithread.chat.task.WriterTask;
import multithread.chat.executor.ReaderTaskExecutor;
import multithread.chat.executor.TaskExecutor;
import multithread.chat.executor.UpdaterTaskExecutor;
import multithread.chat.executor.WriterTaskExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Chat chat;
    private AtomicInteger atomicInteger;
    //Количество Writer
    private static final int WRITER_COUNT = 3;
    //Количество Reader
    private static final int READER_COUNT = 3;
    //Количество Updater
    private static final int UPDATER_COUNT = 1;

    private static Logger logger = LoggerFactory.getLogger(Service.class);

    public Service() {
        chat = new Chat();
        atomicInteger = new AtomicInteger(0);
    }

    public void startChat()  {
        Task writerTask = new WriterTask(chat, atomicInteger);
        Task readerTask = new ReaderTask(chat);
        Task updaterTask = new UpdaterTask(chat);

        TaskExecutor writerTaskExecutor = new WriterTaskExecutor(writerTask,  2, 6);
        TaskExecutor readerTaskExecutor = new ReaderTaskExecutor(readerTask,  3, 5);
        TaskExecutor updaterTaskExecutor = new UpdaterTaskExecutor(updaterTask,  4);

        ExecutorService executorService = Executors.newFixedThreadPool(8 );
        for (int i = 0; i < WRITER_COUNT; i++) {
            executorService.execute(writerTaskExecutor);
        }
        for (int i = 0; i < READER_COUNT; i++) {
            executorService.execute(readerTaskExecutor);
        }
        for (int i = 0; i < UPDATER_COUNT; i++) {
            executorService.execute(updaterTaskExecutor);
        }





    }
}

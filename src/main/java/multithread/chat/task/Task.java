package multithread.chat.task;

import multithread.chat.data.Chat;

import java.util.concurrent.Callable;

public abstract class Task implements Callable<String> {
    protected Chat chat;

    public Task(Chat chat) {
        this.chat = chat;
    }
}

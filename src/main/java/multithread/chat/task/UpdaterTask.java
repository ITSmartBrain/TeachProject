package multithread.chat.task;

import multithread.chat.data.Chat;

public class UpdaterTask extends Task {

    public UpdaterTask(Chat chat) {
        super(chat);
    }

    @Override
    public String call() throws Exception {
        return chat.updateSms();
    }
}

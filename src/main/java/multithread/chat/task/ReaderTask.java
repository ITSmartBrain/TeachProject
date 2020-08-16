package multithread.chat.task;

import multithread.chat.data.Chat;

public class ReaderTask extends Task {

    public ReaderTask(Chat chat) {
        super(chat);
    }

    @Override
    public String call() throws Exception {
        return chat.readSms();
//      logger.info("Считано: " + text);
    }
}

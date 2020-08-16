package multithread.chat.data;


import multithread.chat.exception.NoExistingSmsException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chat {

    private List<SMS> chatSmsQueue = Collections.synchronizedList(new ArrayList<>());
    private List<SMS> bufferSmsQueue = Collections.synchronizedList(new ArrayList<>());
    private final int capacity = 25;

    private Lock lock = new ReentrantLock();

    public String addSMS(String text) throws InterruptedException {
        lock.lock();
        try {
            if(chatSmsQueue.size() < capacity){
                if(bufferSmsQueue.isEmpty()) {
                    chatSmsQueue.add(new SMS(text));
                }else{
                    int count = capacity - chatSmsQueue.size();
                    while(count>0 && !bufferSmsQueue.isEmpty()){
                        chatSmsQueue.add(bufferSmsQueue.remove(0));
                        count--;
                    }
                }
            }else{
                bufferSmsQueue.add(new SMS(text));
            }

        }finally {
            System.out.println("CHAT SIZE: "+chatSmsQueue.size());
            System.out.println("BUFFER SIZE: "+bufferSmsQueue.size());
            lock.unlock();
        }
        return text;
    }

    public String readSms() throws InterruptedException {
        lock.lock();
        try {
            if(!chatSmsQueue.isEmpty()) {
                SMS sms = chatSmsQueue.remove(0);
                return sms.getText();
            }
        }finally {
            lock.unlock();
        }
        throw new NoExistingSmsException("Не удалось считать смс, в чате нет смс");


    }

    public String updateSms() {
        lock.lock();
        try {
            if (!chatSmsQueue.isEmpty()) {
                int randomIndex = ThreadLocalRandom.current().nextInt(chatSmsQueue.size());
                SMS sms = (SMS) chatSmsQueue.get(randomIndex);
                sms.setText(sms.getText() + " modified");
                return sms.getText();
            }
        }finally {
            lock.unlock();
        }

        throw new NoExistingSmsException("Изменение сообщения не удалость, список сообщений пуст");
    }
}

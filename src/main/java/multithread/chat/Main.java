package multithread.chat;


import multithread.chat.service.Service;

public class Main {
    public static void main(String[] args) {
        /*Есть N Writer, M Reader, K Updater
        Каждый Writer пишет 1 смс в чат в заданный интервал секунд в диапазоне [20,60). Емкость чата - 20 сообщений,
        если не помещается в чат, нужно сохранять в буфере.
        Каждый Reader читает 1 смс из чата в заданный интервал секунд в диапазоне [30,50)
        Каждый Updater редактирует случайное смс из часа раз в 40 секунд.

        Реализовать задачу полностью на concarrency api
         */

        Service service = new Service();
        service.startChat();
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyCallable myCallable = new MyCallable();
//        FutureTask ft = new FutureTask(myCallable);
//        new Thread(ft).start();
//        System.out.println(ft.get());

//        Sklad2 sklad2 = new Sklad2();
//        List<String> list = new ArrayList<>();
//        List<FutureTask<String>> listTask = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            MyCallable myCallable = new MyCallable(sklad2);
//            FutureTask<String> ft = new FutureTask<>(myCallable);
//
//            listTask.add(ft);
//            new Thread(ft).start();
//        }

        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sklad2 sklad2 = new Sklad2();
        List<String> list = new ArrayList<>();
        List<Future<String>> listTask = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Future<String> future = executorService.submit(new MyCallable(sklad2));
            listTask.add(future);
        }

        executorService.shutdown();


        for (int i = 0; i < listTask.size(); i++) {
            list.add(listTask.get(i).get());

        }
        System.out.println("Забранные товары:");
        for (int i = 0; i < listTask.size(); i++) {
            list.add(listTask.get(i).get());
            System.out.println(list.get(i));
        }

    }

}

class Sklad2{
    List<String> list = Collections.synchronizedList(new ArrayList<String>());
    public Sklad2(){
        for (int i = 0; i < 50; i++) {
            list.add("Tovar"+i);
        }

    }
}

class MyCallable implements Callable<String>{
    Sklad2 sklad;
    public MyCallable(Sklad2 sklad){
        this.sklad = sklad;
    }
    @Override
    public String call() throws Exception {


        String tovar=null;
        synchronized (sklad) {
            if (sklad.list.size() > 0) {
                System.out.println(Thread.currentThread().getName());
                int val = new Random().nextInt(sklad.list.size());
                tovar = sklad.list.remove(val);
                System.out.println("Забрали товар: "+tovar);

            }
        }
        Thread.sleep(1000);
        return tovar;
    }
}

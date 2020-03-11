import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Build build = new Build();
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        while(build.block.get()<100){
            Future f = executorService.submit(new MyCallable2(new Ekskavator(build.block)));

            list.add(f);
            //Thread.sleep(100);
        }
        executorService.shutdown();
//        for(Future f : list){
//            f.get();
//        }
        System.out.println(build.block.get());
    }
}

class MyCallable2 implements Runnable{
    Ekskavator ekskavator;

    public MyCallable2(Ekskavator ekskavator) {
        this.ekskavator = ekskavator;
    }

    @Override
    public void run() {
        while(ekskavator.ai.get()<100) {

            ekskavator.add();
            System.out.println(Thread.currentThread().getName()+" "+ekskavator.ai.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Build{
    AtomicInteger block = new AtomicInteger();

}

class Ekskavator{
    AtomicInteger ai;
    public Ekskavator(AtomicInteger ai){
        this.ai = ai;
    }

    public void add(){
        ai.incrementAndGet();
    }
}

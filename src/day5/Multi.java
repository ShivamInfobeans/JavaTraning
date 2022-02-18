package day5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multi {
    public static void main(String[] args) {
        // Thread pools used to execute a task efficiently
//        Task task = new Task();
//        Thread thread = new Thread();
//       thread.start()
        // 10 ms will just be wasted to create a thread
        // and start a thread -> run() method will get executed
        // 10 ms <--
        // Thread pool you already maintain a set of thread objects ready
        // It's like during the start of the program
        // you create say 10 Thread objects.
        // thread1.start() <-- run() method and start executing statements.

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // creates a fixed number of threads in a pool.
        // If a thread completes executing a task, it can be reused to excute another task.
        executorService.execute(new Print(1,1000));
        executorService.execute(new Print(2,1000));
        executorService.execute(new Print(3,1000));
        executorService.execute(new Print(4,1000));




    }
}
class Print implements Runnable{
    private Integer integerToPrint;
    private Integer numOfTimeToPrint;

    public Print(Integer _integerToPrint,Integer _numOfTimeToPrint){
        integerToPrint=_integerToPrint;
        numOfTimeToPrint=_numOfTimeToPrint;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + " , "+integerToPrint);
//                 try {
//                     Thread.sleep(1000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
        }
    }
}
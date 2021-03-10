package com.portal.javacore.chapter2.secondTask;

import com.portal.javacore.chapter2.secondTask.threads.A;
import com.portal.javacore.chapter2.secondTask.threads.B;
import com.portal.javacore.chapter2.secondTask.threads.C;
import com.portal.javacore.chapter2.secondTask.threads.D;

import java.util.Optional;
import java.util.concurrent.*;

public class FizzBuzz {
    private int i;
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(1);
    private Phaser phaser = new Phaser(5);
    private ExecutorService service = Executors.newFixedThreadPool(5);
    volatile private boolean hasPrint;

    public FizzBuzz(int i) throws InterruptedException, BrokenBarrierException {
        this.i = i;
        semaphore.acquire();
        semaphore1.acquire();
        semaphore2.acquire();
        for(int j = 1; j <= i; j++){
            service.submit(new A(this, j));
            service.submit(new B(this, j));
            service.submit(new C(this, j));
            service.submit(new D(this, j));
            phaser.arriveAndAwaitAdvance();
        }
        service.shutdown();
    }

    public void fizz(int i) throws InterruptedException, BrokenBarrierException { //3
        semaphore1.acquire();
        if(i % 3 == 0 && hasPrint!= true){
            System.out.print(" fizz,");
            hasPrint = true;
        }
        semaphore2.release();
        phaser.arriveAndAwaitAdvance();
    }

    public void buzz(int i) throws InterruptedException, BrokenBarrierException {  //2
        semaphore.acquire();
        if(i % 5 == 0 && hasPrint!= true){
            System.out.print(" buzz,");
            hasPrint = true;
        }
        semaphore1.release();
        phaser.arriveAndAwaitAdvance();
    }

    public void fizzBuzz(int i) throws InterruptedException, BrokenBarrierException {  //1
        if(i % 5 == 0 && i % 3 == 0 && hasPrint!= true){
            System.out.print(" fizzBuzz,");
            hasPrint = true;
        }
        semaphore.release();
        phaser.arriveAndAwaitAdvance();
    }

    public void count(int i) throws InterruptedException, BrokenBarrierException { //4
        semaphore2.acquire();
        if(hasPrint != true) System.out.print(" " + i + ",");
        hasPrint = false;
        phaser.arriveAndAwaitAdvance();
    }
}

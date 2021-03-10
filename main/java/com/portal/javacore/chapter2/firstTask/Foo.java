package com.portal.javacore.chapter2.firstTask;

import com.portal.javacore.chapter2.firstTask.threads.C;

import java.util.concurrent.*;

public class Foo {

    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(1);

    public Foo() throws InterruptedException {
        semaphore.acquire();
        semaphore2.acquire();
    }


    public void first() throws InterruptedException {
        System.out.print("first");
        semaphore.release();
    }

    public void second() throws InterruptedException {
        semaphore.acquire();
        System.out.print("second");
        semaphore2.release();

    }

    public void third() throws InterruptedException {
        semaphore2.acquire();
        System.out.print("third");
        semaphore2.release();
    }
}

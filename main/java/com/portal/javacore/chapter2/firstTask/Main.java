package com.portal.javacore.chapter2.firstTask;

import com.portal.javacore.chapter2.firstTask.threads.*;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Foo foo = new Foo();
        Thread a = new Thread(new A(foo));
        Thread b = new Thread(new B(foo));
        Thread c = new Thread(new C(foo));
        c.start();
        b.start();
        a.start();

    }


}

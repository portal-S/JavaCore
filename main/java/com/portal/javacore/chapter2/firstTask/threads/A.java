package com.portal.javacore.chapter2.firstTask.threads;

import com.portal.javacore.chapter2.firstTask.Foo;

public class A implements Runnable{

    private Foo foo;

    public A(Foo f){
        this.foo = f;
    }

    @Override
    public void run() {
        try {
            foo.first();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.portal.javacore.chapter2.firstTask.threads;

import com.portal.javacore.chapter2.firstTask.Foo;

public class C implements Runnable{

    private Foo foo;

    public C(Foo f){
        this.foo = f;
    }

    @Override
    public void run() {
        try {
            foo.third();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

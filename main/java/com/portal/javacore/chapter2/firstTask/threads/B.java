package com.portal.javacore.chapter2.firstTask.threads;

import com.portal.javacore.chapter2.firstTask.Foo;

public class B implements Runnable{

    private Foo foo;

    public B(Foo f){
        this.foo = f;
    }

    @Override
    public void run() {
        try {
            foo.second();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.portal.javacore.chapter2.secondTask.threads;

import com.portal.javacore.chapter2.secondTask.FizzBuzz;

import java.util.concurrent.BrokenBarrierException;

public class A implements Runnable{
    private FizzBuzz fizzBuzz;
    private int i;

    public A(FizzBuzz fizzBuzz, int i) {
        this.fizzBuzz = fizzBuzz;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            fizzBuzz.fizz(i);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

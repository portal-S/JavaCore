package com.portal.javacore.chapter2.secondTask.threads;

import com.portal.javacore.chapter2.secondTask.FizzBuzz;

import java.util.concurrent.BrokenBarrierException;

public class C implements Runnable{
    private FizzBuzz fizzBuzz;
    private int i;

    public C(FizzBuzz fizzBuzz, int i) {
        this.fizzBuzz = fizzBuzz;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            fizzBuzz.fizzBuzz(i);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

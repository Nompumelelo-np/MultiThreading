/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.multithreading;
import java.util.Scanner;
import java.lang.Thread;

/**
 *
 * @author Acer-User
 */

class CounterThread extends Thread {
    private int startValue;
    private int step;
    public CounterThread(int startValue, int step) {
        this.startValue = startValue;
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = startValue; i <= 100; i += step) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Multithreading {

    public static void main(String[] args) {
    CounterThread counter1 = new CounterThread(5, 5);
        CounterThread counter2 = new CounterThread(10, 10);
        CounterThread counter3 = new CounterThread(100, 100);

        counter1.setName("Counter 1");
        counter2.setName("Counter 2");
        counter3.setName("Counter 3");

        counter1.setPriority(Thread.MIN_PRIORITY); // Assign minimum priority
        counter2.setPriority(Thread.NORM_PRIORITY); // Assign normal priority
        counter3.setPriority(Thread.MAX_PRIORITY); // Assign maximum priority

        counter1.start();
        counter2.start();
        counter3.start();
    }
}

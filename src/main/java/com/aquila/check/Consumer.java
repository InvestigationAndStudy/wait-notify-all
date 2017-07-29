package com.aquila.check;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true) {
            System.out.println("Consumer start...");
            String message = drop.take();
            System.out.println("Consumer take: " + message);
            try {
                Thread.sleep(rand.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (message.equals("Done")) {
                break;
            }
        }
    }
}

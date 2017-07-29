package com.aquila.check;


import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;
    private final String[] IMPORTANT_INFO = {"Hello", "world", "my", "name", "is", "venya"};

    public Producer(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < IMPORTANT_INFO.length; i++) {
            System.out.println("Producer put: " + IMPORTANT_INFO[i]);
            drop.put(IMPORTANT_INFO[i]);
            try {
                Thread.sleep(rand.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("Done");
    }
}

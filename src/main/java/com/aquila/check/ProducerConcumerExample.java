package com.aquila.check;


public class ProducerConcumerExample {
    public static void main(String [] args) throws InterruptedException {
        final Drop drop = new Drop();

        Thread consumer = new Thread(new Consumer(drop));
        Thread producer = new Thread(new Producer(drop));

        producer.start();
        consumer.start();
    }

}

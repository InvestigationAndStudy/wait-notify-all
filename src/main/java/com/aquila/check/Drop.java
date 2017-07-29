package com.aquila.check;

public class Drop {
    private String message;
    private boolean empty = true;

    public synchronized String take() {
        System.out.println("Drop take message: " + message);
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(final String mess) {
        System.out.println("Drop put message: " + mess);
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.message = mess;
        notifyAll();
    }
}

package com.Thread;

import java.util.Vector;

public class Producer1 extends Thread {
    // initialization of queue size
    static final int MAX = 7;
    private Vector messages = new Vector();

    @Override
    public void run() {
        try {
            while (true) {
                // producing a message to send to the consumer
                putMessages();
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private synchronized void putMessages() {
        try {
            // checks whether the queue is full or not
            while (messages.size() == MAX) {
                // waits for the queue to get empty
                wait();

            }
        } catch (InterruptedException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        // then again adds element or messages
        messages.addElement(new java.util.Date().toString());
        notify();
    }

    public synchronized String getMessages() {
        notify();
        try {
            while (messages.size() == 0) {
                wait();
            }
        } catch (InterruptedException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        String message = (String) messages.firstElement();
        // remove the message from the queue
        messages.remove(message);
        return message;

    }
}

package com.Thread;

public class Comsumer1 extends Thread {
    Producer1 producer1;

    public Comsumer1(Producer1 producer1) {
        this.producer1 = producer1;
    }

    @Override
    public void run() {
        try{
            while (true){
                String message = producer1.getMessages();
                System.out.println("Gor messages " + message);
                sleep(2000);
            }
        }catch (InterruptedException ex){
            System.out.println("Exception: "+ ex);
        }
    }

    public static void main(String[] args) {
        Producer1 producer1 = new Producer1();
        producer1.start();
        new Comsumer1(producer1).start();
    }
}

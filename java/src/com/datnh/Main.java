package com.datnh;

class Count implements Runnable{
    Thread childThread;
    Count()
    {
        childThread = new Thread(this, "My child extending thread");
        System.out.println("My Child thread created" + childThread);
        childThread.start();
    }
    public void run(){
        try {
            for (int i = 10; i >0;i--){
                System.out.println("Print the number: " + i);
                Thread.sleep(1000);
                }
        }catch (InterruptedException e){
            System.out.println("My Child thread interrupted");
        }
        System.out.println("My Child thread is done");
    }
}

public class Main {

    public static void main(String[] args) {
        Count count= new Count();

        try {
            while (count.childThread.isAlive()){
                System.out.println("Main thread is still alive till the child thread is live ");
                Thread.sleep(1500);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread is done!!!");
    }

}

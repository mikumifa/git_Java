package com.Thread.method;

public class Threadtest {
    public static void main(String[] args) {
        Thread T1= new Thread(new Thread01());
        T1.setDaemon(true);
        T1.start();
        for(int i=0;i<100;i++) {
            System.out.println("main:"+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread01 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println("T1:"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().setName("new Name");
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
class Thread02 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println("Fuck:"+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().setName("new Name");
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
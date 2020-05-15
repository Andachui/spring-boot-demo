package com.dachui.quickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interview {
    public static void main(String[] args) {
       Person person1=new Person();
        Person person2=new Person();
        Thread1 thread1=new Thread1(person1,person2);
        Thread2 thread2=new Thread2(person1,person2);
        thread1.start();
        thread2.start();
    }

}


class Thread1 extends  Thread{
    private Person lock1;
    private Person lock2;
    public Thread1(Person lock1,Person lock2){
        this.lock1=lock1;
        this.lock2=lock2;
    }

    @Override
    public void run() {
        try {
            synchronized (lock1) {
                Thread.sleep(1000);
                System.out.println("Thread1 获取到锁1");
                synchronized (lock2) {
                    System.out.println("Thread1 获取到锁2");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends  Thread{
    private Person lock1;
    private Person lock2;
    public Thread2(Person lock1,Person lock2){
       this.lock1=lock1;
        this.lock2=lock2;
    }


    @Override
    public void run() {
        try {
            synchronized (lock2) {
                Thread.sleep(1000);
                System.out.println("Thread2 获取到锁2");
                synchronized (lock1) {
                    System.out.println("Thread2 获取到锁1");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//class MyThred3 extends Thread{
//    @Override
//    public void run() {
//        System.out.println("3");
//        countDownLatch.countDown();
//
//    }
//
//    private CountDownLatch countDownLatch;
//    public MyThred3(CountDownLatch countDownLatch){
//        this.countDownLatch=countDownLatch;
//    }
//}
//
//class MyThred4 extends Thread{
//    @Override
//    public void run() {
//        System.out.println("4");
//        countDownLatch.countDown();
//
//    }
//
//    private CountDownLatch countDownLatch;
//    public MyThred4(CountDownLatch countDownLatch){
//        this.countDownLatch=countDownLatch;
//    }
//}
//
//class MyThred1 extends Thread{
//    @Override
//    public void run() {
//        try {
//            synchronized (class1) {
//                System.out.println("do something");
//                Thread.sleep(1000);
//                synchronized (class2) {
//                    System.out.println("MyThred1 获得所");
//                }
//            }
//        }catch (Exception e){
//
//        }
//
//    }
//
//    Person class1;
//    Person class2;
//    public MyThred1(Person class1,Person class2){
//        this.class1=class1;
//        this.class2=class2;
//    }
//}
//
//class MyThred2 extends Thread{
//    @Override
//    public void run() {
//        try {
//            synchronized (class2) {
//                System.out.println("do something");
//                Thread.sleep(1000);
//                synchronized (class1) {
//                    System.out.println("MyThred2 获得所");
//                }
//            }
//        }catch (Exception e){
//
//        }
//    }
//
//    Person class1;
//    Person class2;
//    public MyThred2(Person class1,Person class2){
//        this.class1=class1;
//        this.class2=class2;
//    }
//}









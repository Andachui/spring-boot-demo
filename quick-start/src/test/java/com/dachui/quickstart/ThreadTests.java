package com.dachui.quickstart;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadTests {
    private static int queueSize = 10;//容量设置
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize,false);//true带表公平,false反之，原因如下注释

    @Test
    public void PAndCModelTest() {
        Producers producer = new Producers(queue);
        Consumers consumer= new Consumers(queue);
        producer.start();
        consumer.start();
        Queue<Integer> queue = new LinkedList<>();
    }
}

class Consumers extends Thread{
    BlockingQueue<Integer> queue;
    public Consumers(BlockingQueue<Integer> queue) {
        this.queue=queue;
    }
    @Override
    public void run() {
        consume();
    }
    private void consume() {
        while(true) {
            try {
                Thread.sleep(1);
                System.out.println("消费者拿了一个"+queue.take()+"号产品");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class Producers extends Thread{
    BlockingQueue<Integer> queue;
    public Producers(BlockingQueue<Integer> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        produce();
    }

    private void produce() {
        int i=0;
        while(true){
            try {
                Thread.sleep(1);
                queue.put(i);
                System.out.println("增加了一个"+i+"号产品");
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

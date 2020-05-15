package com.dachui.quickstart;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interview5 {
    public static void main(String[] args) {

        //lru
        //多线程循环打印
        //生产者消费者
        //死锁
        //单例
        //翻转链表
        //台阶
        //快速排序
        //二分

        //自己jvm调优
        //过一遍自己项目

        //aop
        //事务
        //springboot
        //springmvc
        //生命周期
        //ioc

        //xa(atomikos,narayana)刚性事务2pc saga(servicecomb)柔性事务 tcc(tcc-transaction bytetcc)  ta(seata)
        //seata比一般saga强在哪 隔离性？ 全局锁，虽然可见，但1全局事务不能修改
    }

    class LruCache extends LinkedHashMap<String,String>{
        private int capacity;

        public LruCache(int capacity){
            super(capacity,0.75f,true);
            this.capacity=capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size()>capacity;
        }
    }



}



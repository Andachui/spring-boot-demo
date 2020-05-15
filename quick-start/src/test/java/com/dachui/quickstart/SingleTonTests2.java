package com.dachui.quickstart;

import org.junit.Test;

import java.util.HashMap;


public class SingleTonTests2 {

    public static void main(String[] args) {

    }


}

class LazySingleton2{
    private LazySingleton2(){}

    private static LazySingleton2 instance;


    public static synchronized LazySingleton2 getInstance(){
        if (instance==null){
            instance =new LazySingleton2();
        }
        return instance;
    }
}

class HungerSingleton2{
    private HungerSingleton2(){}

    private static HungerSingleton2 instance =new HungerSingleton2();

    public static  HungerSingleton2 getInstance(){
        return instance;
    }
}

class DoubleCheckSingleton2{
    private DoubleCheckSingleton2(){}

    private static volatile DoubleCheckSingleton2 instance ;

    public static  DoubleCheckSingleton2 getInstance(){
        if(instance==null){
            synchronized (DoubleCheckSingleton2.class){
                if(instance==null){
                    instance=new DoubleCheckSingleton2();
                }
            }
        }
        return instance;
    }
}

class InnerClassSingleton2{
    private InnerClassSingleton2(){}

    private static class InnerClassHolder2{
        private static InnerClassSingleton2 instance=new InnerClassSingleton2();
    }

    public static  InnerClassSingleton2 getInstance(){
        return InnerClassHolder2.instance;
    }
}


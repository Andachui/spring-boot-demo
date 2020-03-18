package com.dachui.quickstart;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;


public class SingleTonTests {

    @Test
    public void doubleCheckSingleton() {

    }


}


class LazySingleton {  //1.懒汉型
    private static LazySingleton instance;
    private LazySingleton (){}
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class EagerSingleton {  //2.饿汉型
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton (){}
    public static EagerSingleton getInstance() {
        return instance;
    }
}

class InnerClassSingleton {  //3.内部类型，可看做饿汉变种
    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
    private InnerClassSingleton (){}
    public static final InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

class DoubleCheckSingleton {  //4.双重校验锁，1.5以后可用
    private volatile static DoubleCheckSingleton singleton;
    private DoubleCheckSingleton (){}
    public static DoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}

enum EnumSingleton {  //5.枚举型，Effective Java作者提倡的。可防止反序列化
    INSTANCE;
}



class RegSingleton{
    static private HashMap registry=new HashMap();
    //静态块，在类被加载时自动执行
    static {
        RegSingleton rs=new RegSingleton();
        registry.put(rs.getClass().getName(),rs);
    }
    //受保护的默认构造函数，如果为继承关系，则可以调用，克服了单例类不能为继承的缺点
    protected RegSingleton(){}
    //静态工厂方法，返回此类的唯一实例
    public static RegSingleton getInstance(String name){
        if(name==null){
            name="RegSingleton";
        }if(registry.get(name)==null){
            try{
                registry.put(name,Class.forName(name).newInstance());
            }catch(Exception ex){ex.printStackTrace();}
        }
        return  (RegSingleton)registry.get(name);
    }
}
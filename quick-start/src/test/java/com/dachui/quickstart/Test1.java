package com.dachui.quickstart;

public class Test1 {
    static final Character y='1';
    static void exchange(Character a){//静态方法，交换a,b的值
        System.out.println(y==a);
        a='b';
    }
    public static void main(String[] args){
        Character x='x';
        char a = 'a';
        System.out.println("before call: " + "i=" +y);//调用前
        exchange(y);                                                                    //值传递，main方法只能调用静态方法
        System.out.println("after call: " + "i=" + y);//调用后


        Person p1=new Person();
        //p1.setName("111");

        Person p2=new Person();
        //p2.setName("111");
        System.out.println(p1.hashCode()==p2.hashCode());
        //System.out.println(p1.equals(p2));
        String s=A.B.name;
    }
}

class A{
    public static class B{
        public static String name="1";
    }
}
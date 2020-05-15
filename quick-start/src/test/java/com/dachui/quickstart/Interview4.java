package com.dachui.quickstart;

import java.util.*;

public class Interview4 {
    public static void main(String[] args) {
//        String s="123";
//        char[] arr=s.toCharArray();
//        int a=arr[1]-'0';
       Set set=new TreeSet(new MyComperator());
        Person person =new Person();
        person.setName("anqi");
        Person person2 =new Person();
        person2.setName("anqi");
        set.add(person);
        set.add(person2);
        System.out.println(set);
        List list=new ArrayList();
    }


}

class MyComperator implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        Person person1=(Person)o1;
        Person person2=(Person)o2;
        if(((Person) o1).getName().equals(((Person) o2).getName())){
            return 0;
        }else {
            return 1;
        }
    }
}


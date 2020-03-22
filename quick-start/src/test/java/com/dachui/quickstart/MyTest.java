package com.dachui.quickstart;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
        HashMap map=new HashMap();
        map.put("1","2");
        System.out.println(map.hashCode());
        Map map2=new HashMap();
        map2.put("3","4");
        System.out.println(map.hashCode());
        System.out.println(map.equals(map2));
        System.out.println(map==map2);
       int a= Solution.lengthOfLongestSubstring("pwwkew");
//        System.out.println(a);

        Person person1=new Person();
        person1.setName("dachui");
        Person person2=new Person();
        person2.setName("dachui");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.equals(person2));

    }
}

class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
         Person a=(Person)obj;
         return this.name.equals(a.getName());
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            map=new HashMap<>();
            map.put(c,1);
            for(int j=i+1;j<s.length();j++){
                Integer temp=map.get(s.charAt(j));
                if(temp!=null){
                    continue;
                }
                map.put(s.charAt(j),1);
            }
            if(map.size()>max){
                max=map.size();
            }
        }
        return max;
    }
}

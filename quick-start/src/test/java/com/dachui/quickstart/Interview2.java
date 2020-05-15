package com.dachui.quickstart;

import java.util.HashMap;
import java.util.Map;

public class Interview2 {
    static  Map<Character,Integer> map;
    public static void main(String[] args) {
        System.out.println(getByString("A"));
        System.out.println(getByString("ZY"));
        System.out.println(getByString("BC"));
        System.out.println(getByString("ABC"));

    }

    public static int getByString(String str){
        if(str==null||str.equals("")){
            return -1;
        }

        int res=0;
        for(int i=0;i<str.length();i++){
            Character s=str.charAt(i);
            Integer temp=map.get(s);
            if(temp==null){
                return -1;
            }
            res=(res*26+temp);
        }
        return res;
    }

    static {
        map=new HashMap<>();

        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('E', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);map.put('W', 23);map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);






    }

}












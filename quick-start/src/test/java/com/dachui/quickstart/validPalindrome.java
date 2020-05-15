package com.dachui.quickstart;

public class validPalindrome {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        //双指针循环找出不等于的字符索引
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        //删除左边循环判断
        i=i+1;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                break;
            }
        }
        if(i>=j){
            return true;
        }


        //删除右边循环判断
        j=j-1;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                break;
            }
        }
        if(i>=j){
            return true;
        }

        //如果上面都是false，那么结果肯定是false
        return false;
    }


}

package com.dachui.quickstart;

import java.util.*;

public class MergeArea {
    public static void main(String[] args) {
        int[] arr=new int[3];
        arr[1]=4;
        arr[2]=3;
        arr[3]=2;
        LinkedHashMap map=new LinkedHashMap();
        map.get()
    }
}
class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.parallelSort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]>0?;
            }
        });

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });


    }
}

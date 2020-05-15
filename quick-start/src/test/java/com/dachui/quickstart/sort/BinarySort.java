package com.dachui.quickstart.sort;

public class BinarySort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //System.out.println(binarySortRecursion(array, 5, 0, array.length - 1));
        System.out.println(binarySort(array, 5));
    }

    /**
     * 循环实现二分查找
     * 时间复杂度是O(logN),最好情况下为O（1）
     * @param array
     * @param key
     * @return
     */
    public static int binarySort(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

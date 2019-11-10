package com.app2m.java.practice.algorithm;

/**
 * 选择排序
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 *
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {1, 5, 5, 4, 3, 3, 3, 9, 7, 9, 5, 1, 1, 1, 2};
        printArray("Original", array);
        selectionSort(array);
        printArray("Result", array);
    }
    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    static void printArray(String prefix, int[] array) {
        System.out.print(prefix + ": [");
        for(int i:array) {
            System.out.print(i+", ");
        }
        System.out.println("]");
    }
}


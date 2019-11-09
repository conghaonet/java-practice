package com.app2m.java.practice.algorithm;

/**
 * 二分法查找
 * 
 * @author hao.cong
 *
 */
public class BisectionMethod {

	public static void main(String[] args) {
		int[] arr = { 12, 23, 34, 45, 56, 67, 77, 89, 90 };
		System.out.println(bisectionSearchSmall2Big(arr, 45));
		System.out.println(bisectionSearchSmall2Big(arr, 99));

	}

	/**
	 * 在从小到大排列的有序数组中查找，时间复杂度：O(log2n)。
	 * @param arr 从小到大排列的有序数组
	 * @param key 要查找的值
	 * @return 返回查找后的结果，返回数组索引。返回-1：未在数组中找到相应的值。
	 */
	public static int bisectionSearchSmall2Big(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (key < arr[middle]) {
				end = middle - 1;
			} else if (key > arr[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}

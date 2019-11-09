package com.app2m.java.practice.algorithm;

/**
 * 冒泡法排序
 * @author hao.cong
 *
 */
public class MaoPao {
	public static void main(String[] args) {
		int array[] = {-3, 4, 2, 9, -9, 7, -7, 0, 5, 3};
		printArray("Original", array);
		sortSmall2Big(array);
		printArray("Result", array);
	}
	
	/**
	 * 冒泡法排序，从小到大。时间复杂度：n的2次方
	 * @param array 无序数组
	 */
	public static void sortSmall2Big(int[] array) {
		for (int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				printArray("sort i="+i + " j="+j, array);
			}
			printArray("sort i="+i, array);
		}
	}

	static void printArray(String prefix, int[] array) {
		System.out.print(prefix + ": [");
		for(int i:array) {
			System.out.print(i+", ");
		}
		System.out.println("]");
	}
}

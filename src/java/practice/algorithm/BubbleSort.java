package java.practice.algorithm;

/**
 * 冒泡法排序
 * https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 * @author hao.cong
 *
 */
public class BubbleSort {
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

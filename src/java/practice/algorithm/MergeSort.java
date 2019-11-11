package java.practice.algorithm;

/**
 * 归并排序
 * 归并操作(merge)，也叫归并算法，指的是将两个顺序序列合并成一个顺序序列的方法。
 * 如　设有数列{6，202，100，301，38，8，1}
 * 初始状态：6,202,100,301,38,8，1
 * 第一次归并后：{6,202},{100,301},{8,38},{1}，比较次数：3；
 * 第二次归并后：{6,100,202,301}，{1,8,38}，比较次数：4；
 * 第三次归并后：{1,6,8,38,100,202,301},比较次数：4；
 * 总的比较次数为：3+4+4=11,；
 * 逆序数为14；
 * @author hao.cong
 *
 */
public class MergeSort {
	public static void main(String[] args) {  
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data);  
        mergeSort(data);  
        System.out.println("排序后的数组：");  
        print(data);  
    }  
  
    public static void mergeSort(int[] data) {  
        sort(data, 0, data.length - 1);  
    }  
  
    public static void sort(int[] data, int left, int right) {  
        if (left >= right) return;  
        // 找出中间索引  
        int center = (left + right) / 2;  
        // 对左边数组进行递归  
        sort(data, left, center);  
        // 对右边数组进行递归  
        sort(data, center + 1, right);  
        // 合并  
        merge(data, left, center, right);  
        print(data);  
    }  
  
    /** 
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序 
     *  
     * @param data 
     *            数组对象 
     * @param left 
     *            左数组的第一个元素的索引 
     * @param center 
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
     * @param right 
     *            右数组最后一个元素的索引 
     */  
    public static void merge(int[] data, int left, int center, int right) {  
        // 临时数组  
        int[] tmpArr = new int[data.length];  
        // 右数组第一个元素索引  
        int mid = center + 1;  
        // third 记录临时数组的索引  
        int third = left;  
        // 缓存左数组第一个元素的索引  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            // 从两个数组中取出最小的放入临时数组  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
}

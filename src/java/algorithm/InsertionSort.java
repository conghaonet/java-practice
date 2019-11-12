package algorithm;

/**
 * 插入排序
 * 插入排序(Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始有序表只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
 *
 * https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif
 */
public class InsertionSort {
    public static void main(String args[]) {
        int array[]={12,5,17,16,19,23,14,52,13};
        insertionSort(array);
        printArray("Result", array);
    }

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++){
            int insertVal=arr[i];
            //insertVal准备和前一个数比较
            int index=i-1;
            while(index >= 0 && insertVal < arr[index]){
                //将arr[index]向后移动一位
                arr[index+1]=arr[index];
                index--;
            }
            //将insertVal的值插入适当位置
            arr[index+1]=insertVal;
        }
    }

    static void printArray(String prefix, int[] array) {
        if (prefix != null && !prefix.isEmpty()) System.out.print(prefix + ": ");
        System.out.print("[");
        for(int index=0; index<array.length; index++) {
            if (index > 0) System.out.print(", ");
            System.out.print(array[index]);
        }
        System.out.println("]");
    }
}

package algorithm;

/**
 * 二分法查找（折半查找）
 *
 * 二分法查找适用于大的数据，但前提条件是数据必须是有序的。
 * 他的原理是先和中间的比较，如果等于就直接返回，如果小于就在前半部分继续使用二分法进行查找，如果大于则在后半部分继续使用二分法进行查找
 * https://upload.wikimedia.org/wikipedia/commons/8/83/Binary_Search_Depiction.svg
 *
 * 时间复杂度最小为O(1),第一个就找到要找的数；
 * 时间复杂度最大为O(log2 n)，最后一次找到要找的数；
 * 对于n个元素的情况：
 * 第一次二分：n/2
 * 第二次二分：n/2^2= n/4
 * ......
 * m次二分：n/(2^m)
 * 在最坏情况下是在排除到只剩下最后一个值之后得到结果，所以为
 * n/(2^m)=1;
 * 2^m=n;
 * 所以时间复杂度为：log2n 也即log（n）；
 *
 * 对数公式：https://baike.baidu.com/item/%E5%AF%B9%E6%95%B0%E5%85%AC%E5%BC%8F/5557846
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        int index = binarySearch(array, 14);

        System.out.println("Search result: index = " + index);
    }

    /**
     *
     * @param array 从小到大排列的有序数组
     * @param value 要查找的值
     * @return 如果找到了返回数组的索引值，如果返回-1表示没找到
     */
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            // 这样写会有个问题，当数据比较大并且要查找的值在后面的时候，求middle可能会出现溢出
            // int middle = (low + high) >> 1;
            // 所以一般情况下我们要这样写：
            int middle = low + ((high - low) >> 1);
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }
}

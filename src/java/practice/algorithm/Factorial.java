package java.practice.algorithm;

/**
 * 阶乘算法
 * 
 * @author hao.cong
 *
 */
public class Factorial {

	public static void main(String[] args) {
		//因为int只有4个字节，所以这里用long（8个字节）
		//最大只能算到20的阶乘，在大的话就超出了long的最大值了
		long n=20;
		System.out.println("递归，"+n+"的阶乘"+getFactorialSum(n));
		System.out.println("非递归，"+n+"的阶乘"+getFactorialSum2(n));
	}

	/**
	 * 递归实现阶乘
	 * 
	 * @param n
	 * @return
	 */
	public static long getFactorialSum(long n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return getFactorialSum(n - 1) * n;
		}
	}

	/**
	 * 非递归实现阶乘
	 * 
	 * @param n
	 * @return
	 */
	public static long getFactorialSum2(long n) {
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = sum * i;
		}
		return sum;
	}
}

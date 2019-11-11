package java.practice.algorithm;

/**
 * 排列组合问题
 * @author hao.cong
 *
 */
public class PermutationAndCombination {
	public static void main(String[] args) {
		System.out.println("排列："+permutation(11,5));
		System.out.println("组合："+combination(11,5));
	}
	
	/**
	 * 排列问题，从base个数中，选出sub个数，共有几种组合
	 * @param base
	 * @param sub
	 * @return
	 */
	public static int permutation(int base, int sub) {
		int value = 1;
		for(int i=0;i<sub;i++) {
			value = value * (base - i);
		}
		return value;
	}

	/**
	 * 组合问题，从base个数中，选出sub个数，共有几种组合
	 * @param base
	 * @param sub
	 * @return
	 */
	public static int combination(int base, int sub) {
		int a = permutation(base, sub);
		int temp = 1;
		for(int i=1; i<=sub; i++) {
			temp = temp * i;
		}
		return a/temp;
	}
}

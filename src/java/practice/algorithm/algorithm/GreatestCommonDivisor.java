package java.practice.algorithm.algorithm;

/**
 * 求最大公约数（greatest common divisor），最小公倍数（least common multiple）
 * @author hao.cong
 *
 */
public class GreatestCommonDivisor {
	public static void main(String[] args) {
		int m = 25;
		int n = 20;
		System.out.println(m+"和"+n+"的最大公约数："+gcd(m,n));
		System.out.println(m+"和"+n+"的最大公约数："+gcd2(m,n));
		lcm(m,n);
	}
	/**
	 * 递归实现
	 * 求m和n的最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m, int n){
		if(n == 0) {
			return m;
		} else if(m <= n) {
			return gcd(n, m);
		} else {
			return gcd(n, m % n);
		}
	}
	/**
	 * 非递归实现
	 * 求m和n的最大公约数
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd2(int m, int n){
		if(m >= n){
			while(n != 0){
				int rem = m % n;
				m = n;
				n = rem;
			}
		} else {
			gcd2(n,m);
		}
		return m;
	}
	/**
	 * 求m和n的最小公倍数（ least common multiple）
	 * @param m
	 * @param n
	 */
	public static void lcm(int m, int n) {
		int intLcm = (m * n) / gcd2(m, n);
		System.out.println(m+"和"+n+"的最小公倍数："+intLcm);
	}
}

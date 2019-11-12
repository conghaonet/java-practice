package algorithm;

/**
 * 登台阶问题
 * 楼梯有n个台阶，上楼可以一步上1阶，也可以一步上2阶，一共有多少种上楼的方法？
 * @author hao.cong
 *
 */
public class Stairs {
	public static void main(String[] args) {
		int stairs = 48;
		long time = System.currentTimeMillis();
		
		System.out.println(count(stairs));
		System.out.println("递归方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");
		time = System.currentTimeMillis();
		System.out.println(countB(stairs));
		System.out.println("数组方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");

	}
	/**
	 * 用递归方式解决
	 * @param stairs 台阶数
	 * @return 一共有多少种走法
	 */
	public static int count(int stairs) {
//		System.out.println(stairs);
		if(stairs <= 0) return stairs;
		else if(stairs == 1) return 1;
		else if(stairs == 2) return 2;
		else return count(stairs - 1) + count(stairs - 2);
	}
	
	/**
	 * 用数组方式解决
	 * @param stairs 台阶数
	 * @return 一共有多少种走法
	 */
	public static int countB(int stairs) {
		int R[] = new int[stairs];
	    R[0] = 1;  //一个台阶只有一种走法  
	    R[1] = 2;  //两个台阶共有两种种走法
	    for (int a = 2 ; a < stairs; a++) {
	        R[a] = R[a-1] + R[a-2];
	    }
	    return R[stairs-1];
	}
}

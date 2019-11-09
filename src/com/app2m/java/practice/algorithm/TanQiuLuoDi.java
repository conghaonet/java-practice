package com.app2m.java.practice.algorithm;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在第10次落地时，共经过多少米？
 * 第10次反弹多高？ 
 * @author hao.cong
 *
 */
public class TanQiuLuoDi {
	public static void main(String[] args) {
		int times = 20;
		long time = System.currentTimeMillis();		
		System.out.println(count(times));
		System.out.println("递归方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");
		time = System.currentTimeMillis();
		System.out.println(countB(times));
		System.out.println("数组方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");
	}
	/**
	 * 用递归方式解决
	 * @param stairs 落地次数
	 * @return 第n次落地后，小球经过的距离总和
	 */
	public static double count(int times) {
//		System.out.println(times);
		double high = 100;
		if(times == 1) return 100d;
		else return count(times - 1) + (high / (Math.pow(2, times-1))*2);
	}
	
	/**
	 * 用数组方式解决
	 * @param stairs 落地次数
	 * @return 第n次落地后，小球经过的距离总和
	 */
	public static double countB(int times) {
		double high = 100;
		double R[] = new double[times];
	    R[0] = 100d;  //一个台阶只有一种走法  
	    for (int a = 1 ; a < times; a++) {
	        R[a] = R[a-1] + (high / (Math.pow(2, a))*2);
	    }
	    return R[times-1];
	}
}

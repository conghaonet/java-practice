package java.practice.algorithm;

/**
 * 已知一对兔子每一个月可以生一对小兔子， 而一对兔子出生后第三个月开始生小兔子。
 * 假如一年内没有发生死亡，则一对兔子一年内能繁殖成多少对？
 * 依次类推可以列出下表：
 * 经过月数：---1---2---3---4---5---6---7---8---9---10---11---12
 * 兔子对数：---1---1---2---3---5---8--13--21--34--55--89--144
 * 
 * @author hao.cong
 *
 */
public class Rabbits {
	public static void main(String[] args) {
		int months = 12;
		long time = System.currentTimeMillis();
		
		System.out.println(count(months));
		System.out.println("递归方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");
		time = System.currentTimeMillis();
		System.out.println(countB(months));
		System.out.println("数组方式耗时：" + (float)(System.currentTimeMillis()-time)/1000+" 秒");
		
	}
	
	/**
	 * 用递归方式解决
	 * @param months 持续月数
	 * @return 最后一月一共有多少只兔子
	 */
	public static int count(int months) {
//		System.out.println(month);
		if(months <= 0) return months;
		else if(months == 1) return 1; //第一月份的兔子数
		else if(months == 2) return 1; //第二月份的兔子数
		else return count(months - 1) + count(months - 2);
	}
	
	/**
	 * 用数组方式解决
	 * @param months 持续月数
	 * @return 最后一月一共有多少只兔子
	 */
	public static int countB(int months) {
		int R[] = new int[months];  //每月的兔子数
	    R[0] = 1;  //第一月份的兔子数  
	    R[1] = 1;  //第二月份的兔子数  
	    for (int a = 2 ; a < months; a++) {
	        R[a] = R[a-1] + R[a-2];
	    }
	    return R[months-1];
	}
}
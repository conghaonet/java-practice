package java.practice.algorithm;

/**
 * 汉诺塔问题(递归) 
 * @author hao.cong
 *
 */
public class HanoiTower {
	public static void main(String[] args) {
//		System.out.println("输入盘子的个数：");
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		System.out.println("2个盘子");
//		move(2,'A','B','C');
		System.out.println("3个盘子");
		move(2,'A','B','C');
//		System.out.println("4个盘子");
//		move(4,'A','B','C');
		
	}
	/**
	 * 将A塔上的盘子移到C塔。A塔上的盘子，最大的一个在底下，其余一个比一个小，依次叠上去。
	 * 移动的时候始终只能小盘子压着大盘子。而且每次只能移动一个。
	 * 移动的次数应等于2的n次方减1：Math.pow(2,n)-1
	 * 
	 * 算法：当只有一个盘子的时候，只需要从将A塔上的一个盘子移到C塔上。
	 * 当A塔上有两个盘子是，先将A塔上的1号盘子（编号从上到下）移动到B塔上，再将A塔上的2号盘子移动的C塔上，最后将B塔上的小盘子移动到C塔上。
	 * 当A塔上有3个盘子时，先将A塔上编号1至2的盘子（共2个）移动到B塔上（需借助C塔），然后将A塔上的3号最大的盘子移动到C塔，最后将B塔上的两个盘子借助A塔移动到C塔上。
	 * 当A塔上有n个盘子是，先将A塔上编号1至n-1的盘子（共n-1个）移动到B塔上（借助C塔），然后将A塔上最大的n号盘子移动到C塔上，最后将B塔上的n-1个盘子借助A塔移动到C塔上。
	 * 综上所述，除了只有一个盘子时不需要借助其他塔外，其余情况均一样（只是事件的复杂程度不一样）。
	 * @param n 盘子个数
	 * @param a	A塔，初始塔
	 * @param b B塔，辅助塔
	 * @param c C塔，目标塔（将盘子最终移到该塔）
	 */
	public static void move(int n, char a, char b, char c) {
		if(n == 1) {
			System.out.println("Disk " + n + " , " + a + " --> " + c);
		} else {
			move(n - 1, a, c, b);
			System.out.println("Disk " + n + " , " + a + " --> " + c);
			move(n - 1, b, a, c);
		}
	}
}

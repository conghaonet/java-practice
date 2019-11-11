package java.practice.algorithm;

/**
 * 猴子吃桃子问题
 * 
 * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个。
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。
 * 求第一天共摘了多少。（1534）
 * 
 * 具体思路如下：
 * 第10天剩余桃数：1
 * 第9天剩余桃数：（1+1）*2=4
 * 第8天剩余桃数：（4+1）*2=10
 * ......
 * 规律很明显，即每天剩余的桃数是第二天桃数加1的两倍。
 * @author hao.cong
 *
 */
public class MonkeyEatPeach {
	/**
	 * 非递归方法
	 * @return 第一天摘了多少个桃子
	 */
	public static int getPeachCount() {
		int value = 1;
		for(int i=9;i>=1;i--) {
			value = (value + 1) * 2;
		}
		return value;
	}
	
	/**
	 * 递归方法
	 * @return 第一天摘了多少个桃子
	 */
	public static int getPeachCount(int day) {
		if(day == 10) {
			return 1;
		} else {
			return (getPeachCount(day + 1) + 1) * 2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("非递归: 第一天摘了 "+getPeachCount()+" 个桃子。");
		System.out.println("递归: 第一天摘了 "+getPeachCount(1)+" 个桃子。");
	}
}

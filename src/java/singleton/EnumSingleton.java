package singleton;

/**
 * 使用 enum 实现单例模式
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，
 * 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * JDK 1.5以后才支持enum
 * 
 * @author hao.cong
 *
 */
public enum EnumSingleton {
	// 唯一实例
	INSTANCE;
	
	public void whateverMethod() {
	}
	
	public void print() {
        System.out.println("使用 enum 实现单例模式");
    }
	
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.print();
	}
}

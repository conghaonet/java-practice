package singleton;

/**
 * 使用 volatile 实现单例模式
 * 俗称双重检查锁定，具备Lazy loading
 * @author hao.cong
 *
 */
public class VolatileSingleton {
	public static volatile VolatileSingleton instance;
	private VolatileSingleton() {
	}
	
	public static VolatileSingleton getInstance() {
		if(instance == null) {
			synchronized(VolatileSingleton.class) {
				if(instance == null) {
					instance = new VolatileSingleton();
				}
			}
		}
		return instance;
	}
	
	private void print() {
		System.out.println("使用 volatile 实现单例模式。");
	}
	
	public static void main(String[] args) {
		VolatileSingleton.getInstance().print();
	}
}

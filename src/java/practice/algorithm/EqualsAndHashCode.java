package java.practice.algorithm;


import com.sun.istack.internal.NotNull;

import java.util.HashSet;
import java.util.Set;


/**
 * 重写equals方法时，应同时重写hashCode方法。
 * equals返回ture时，hashCode一定相等。hashCode相等时，equlas不一定为true。
 * 如果用到HashSet等集合对象时，如果不重写hashCode方法，则会出现重复对象的问题。
 * 
 * @author hao.cong
 *
 */
public class EqualsAndHashCode {
	private int id;
	
	@NotNull
	private String name;

	public EqualsAndHashCode(int id, @NotNull String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EqualsAndHashCode)) {
			return false;
		}
		if(this.name == null || this.id == 0) return false;
		final EqualsAndHashCode other = (EqualsAndHashCode) obj;
		if (this.name.equals(other.name) && this.id == other.id) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 自己实现业务逻辑额，取决于设计者何时希望两个对象相等。
	 * 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + objectHashCode(name);
		result = 37 * result + id;
		return result;
	}
	private int objectHashCode(Object obj){
        if (obj == null) {  
            return 0;  
        } else {
            return obj.hashCode();  
		}
    }  
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		EqualsAndHashCode objA = new EqualsAndHashCode(1, "a");
		EqualsAndHashCode objB = new EqualsAndHashCode(1, "a");
		System.out.println("Objects equals is "+objA.equals(objB));
		Set<EqualsAndHashCode> set = new HashSet<>();
		set.add(objA);
		set.add(objB);
		System.out.println("Set size is "+set.size());
	}

}

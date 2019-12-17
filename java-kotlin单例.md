# 单例
## 饿汉式
* Java实现
```java
public class SingletonDemo {
    private static SingletonDemo instance=new SingletonDemo();
    private SingletonDemo(){

    }
    public static SingletonDemo getInstance(){
        return instance;
    }
}
```

* Kotlin实现
```kotlin
object SingletonDemo {
  //...
}
```

## 双重校验锁式(Double Check)
* Java实现
```java
public class SingletonDemo {
    private volatile static SingletonDemo instance;
    private SingletonDemo(){} 
    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
```
* Kotlin实现
```kotlin
class SingletonDemo private constructor() {
    companion object {
        val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        SingletonDemo() }
    }
}
```

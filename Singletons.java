//单例模式的作用：在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例，这些应用都或多或少具有资源管理器的功能。
//1、控制资源的使用，通过线程同步来控制资源的并发访问；
//2、控制实例产生的数量，达到节约资源的目的。
//3、作为通信媒介使用，也就是数据共享，它可以在不建立直接关联的条件下，让多个不相关的两个线程或者进程之间实现通信。

//只适用于单线程的懒汉模式
public class Singleton{
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
//适用于多线程的懒汉模式
public class Singleton{
    private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
//饿汉模式
public class Singleton{
    private static Singleton instance =new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
//枚举
public enum Singleton {
    INSTANCE;
    public void whatevermethod() {
        
    }
}
//双重校验锁
public class Singleton{
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
//静态内部类
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton() {
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}


/*
* 写一个单例模式：
*/
public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){//进入区域后，再检查一遍，如果还是null，才创建实例
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Singleton u1 = Singleton.getInstance();
        Singleton u2 = Singleton.getInstance();
        System.out.println("两个实例是否相同： " + (u1 == u2));

    }
    public static void main1(String[] args) {
        Singleton1 u1 = Singleton1.getInstance();
        Singleton1 u2 = Singleton1.getInstance();
        System.out.println("两个实例是否相同： " + (u1 == u2));
    }
}

/*
* 用静态内部类实现一个单例模式
*/
class Singleton1{
    //私有化构造器
    private Singleton1(){

    }
    //对外提供公共的访问方法
    public static Singleton1 getInstance(){
        return UserSingletonHolder.INSTANCE;
    }
    //写一个静态内部类，里面实例化外部类
    private static class UserSingletonHolder{
        private static final Singleton1 INSTANCE = new Singleton1();
    }
}

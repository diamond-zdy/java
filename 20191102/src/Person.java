//设计一个包含多个构造函数的类，用这些构造函数实例化对象
public class Person {
    public String name;
    public String sex;
    public int age;

    public Person(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + sex + age + "正在吃饭");
    }

    public void sleep() {
        System.out.println(name + sex + age + "正在睡觉");
    }

    public void show() {
        System.out.println(name + sex + age);
    }
}

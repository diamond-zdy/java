public class Test {
    public static void main(String[] args) {
        Person zhangsan = new Person("张三","男",18);
        Person lisi = new Person("李思","女",20);
        zhangsan.show();
        lisi.show();
        zhangsan.eat();
        lisi.sleep();
    }
}

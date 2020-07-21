/*
* 用枚举实现一个单例模式
*/

public enum TestEnum {
    INSTANCE;
    public TestEnum getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        TestEnum singleton1 = TestEnum.INSTANCE;
        TestEnum singleton2 = TestEnum.INSTANCE;
        System.out.println("两个实例是否相同：" + (singleton1 == singleton2));
    }
}

//交换两个变量的值 实现实参的交换
public class Test {
    public static void main(String[] args) {
        Change object = new Change();
        object.setNum1(2);
        object.setNum2(5);
        System.out.println("num1:" + object.getNum1() + " num2:" + object.getNum2());

        int temp;
        temp = object.getNum1();
        object.setNum1(object.getNum2());
        object.setNum2(temp);
        System.out.println("num:" + object.getNum1() + " num2:" + object.getNum2());
    }
}

//1、编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
//除四种运算.
public class Calculator {
    private int num1;
    private int num2;

    public int add(int a,int b){
        this.num1 = a;
        this.num2 = b;
        return this.num2 + this.num1;
    }
    public int sub(int a,int b){
        this.num1 = a;
        this.num2 = b;
        return this.num1 - this.num2;
    }
    public int mul(int a,int b){
        this.num1 = a;
        this.num2 = b;
        return this.num2 * this.num1;
    }
    public int div(int a,int b){
        this.num1 = a;
        this.num2 = b;
        return this.num1 / this.num2;
    }
}



/**
 * Created with IntelliJ IDEA.
 * Description:  我想要一个通用的顺序表
 * User: GAOBO  泛型
 * Date: 2019-12-08
 * Time: 10:40
 */

/**
 * MyArrayList:泛型类
 * <T>:T他只是一个占位符，标识当前类为泛型类
 * @param <T>
 *
 * 一、泛型的意义是什么？
 *    1、可以进行自动类型检查
 *    2、自动进行类型转换
 * 二、泛型的坑：
 *     1.泛型类型的参数不能是简单类型。一定要是对象的包装类
 *     MyArrayList<int> myArrayList3 = new MyArrayList<>();
 *     2、不能够new一个泛型类型的数组T[] elem = new T[10];
 *     3、泛型类型的参数不参与类型的组成
 * 三、面试问题：
 *     泛型到底是怎么编译的？
 *     *****擦除机制****** ：擦除为Object
 */
public class MyArrayList<T> {
    public T[] elem;
    public int usedSize;
    public MyArrayList() {
        //this.elem = new T[10];
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }
    public void add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public T get() {
        return this.elem[this.usedSize-1];
    }
}

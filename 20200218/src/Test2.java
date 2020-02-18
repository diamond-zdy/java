import java.util.ArrayList;
/*
* 泛型
* */
class MyStack<T>{
    public T[] elem;
    public int top;
    public MyStack(){
        this.elem = (T[])new Object[10];
        this.top = 0;
    }
    public void push(T data){
        this.elem[top++] = data;
    }
    public T pop(){
        T oldData = this.elem[top-1];
        top--;
        return oldData;
    }
}
class Algorithm<T extends Comparable<T>>{
    public T findMaxVal(T[] array){
        T maxVal = array[0];
        for(int i = 0;i < array.length;i++){
            if (array[i].compareTo(maxVal) > 0){
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}
class Algorithm2 {
    public static <T extends Comparable<T>> T findMaxVal(T[] array) {
        T maxVal = array[0];
        for (int i = 0;i < array.length;i++){
            if (array[i].compareTo(maxVal) > 0){
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}
class Algorithm3 {
    public static<T> void printList(ArrayList<T> array){
        for (T obj:array) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    public static void printList2(ArrayList<?> array){
        for (Object obj:array) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
public class Test2 {
    public static void main2(String[] args) {
        Integer[] array = {10,8,7,89,46,87};
        Integer ret = Algorithm2.<Integer>findMaxVal(array);
        System.out.println(ret);
    }
    public static void main3(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Algorithm3.printList(arrayList);
    }

    public static void main1(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array = {10,8,7,89,46,87};
        Integer ret = algorithm.findMaxVal(array);
        System.out.println(ret);
    }

    public static void main5(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        int a = myStack.pop();
        System.out.println(a);
        MyStack<String> myStack1 = new MyStack<>();
        myStack1.push("zdy");
        String s = myStack1.pop();
        System.out.println(s);
        System.out.println(myStack);
        System.out.println(myStack1);
    }
}

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(func1());
    }
    public static int func1(){
        try {
            return 0;
        }finally {
            return 20;
        }
    }
    public static void main8(String[] args) {
        System.out.println(divide(10,0));
    }
    public static int divide(int x,int y){
        if (y == 0) {
            throw new ArithmeticException("抛出除0异常");
        }
        return x/y;
    }
    public static void main7(String[] args) {
        func();
        System.out.println("after try catch");
    }
    public static void main6(String[] args) {
        try {
            func();
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
    public static void func() {
        int[] arr = {1,2,3};
        System.out.println(arr[100]);
    }
    public static void main5(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            System.out.println("num = " + num);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main4(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally code");
        }
    }
    public static void main3(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界异常");
            e.printStackTrace();
        }catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
    public static void main2(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            //catch语句不能捕获刚才的空指针异常，因为异常类型不匹配
        }
    }
    public static void main1(String[] args) {
        int[] arr = {1,2,3};
        try{
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
        /*执行结果：
        before
        java.lang.ArrayIndexOutOfBoundsException: 100
        after try catch*/
    }
}

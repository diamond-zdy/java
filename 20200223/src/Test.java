//给定一个N 判断需要多少步才能变成一个斐波那契数
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(getStep(N));
    }
    private static int getStep(int N){
        int x = 0;
        int count = 0;
        while (count >= 0){
            if (Fibonacci(count) >= N){
                x = Fibonacci(count);
                break;
            }else {
                count++;
            }
        }
        int y = Fibonacci(count-1);
        int a = N-y;
        int b = x-N;
        if (a<=b){
            return a;
        }
        return b;
    }
    private static int Fibonacci(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}

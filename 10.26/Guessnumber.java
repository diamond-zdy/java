import java.util.Random;
import java.util.Scanner;

public class Guessnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int a = random.nextInt(100);
        while (true) {
            System.out.println("请输入一个数：");
            int num = scanner.nextInt();
            if(num > a) {
                System.out.println("猜大了");
            }else if(num < a) {
                System.out.println("猜小了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
        scanner.close();
    }
}

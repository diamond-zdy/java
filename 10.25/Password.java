//输入密码，最多输入三次
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 3;

        while (count != 0) {
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            if ("abcde".equals(password)) {
                System.out.println("密码正确");
                break;
            } else {
                System.out.println("密码错误");
                count--;
            }
        }
    }
}

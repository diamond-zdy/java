//牛客网 下厨房问题
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.sys();
    }
    private void sys(){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNext()){
            set.add(sc.next());
        }
        System.out.println(set.size());
    }
}

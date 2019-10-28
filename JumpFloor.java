//一只青蛙一次可以跳上1级台阶,也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少跳法
public class JumpFloor {
    public static int JumpFloor1(int n){
        if(n<1){
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return JumpFloor1(n-1)+JumpFloor1(n-2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor.JumpFloor1(3));
    }
}

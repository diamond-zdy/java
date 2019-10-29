//一只青蛙一次可以跳上1级台阶,也可以跳上2级……它也可以跳上n级。求该青蛙跳上台阶有几种跳法。
public class JumpFloorII {
    public static int Jump(int target) {
        if(target == 0) {
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= target;i++){
            for (int j = 0;j < i;j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
        /*int a = 1;
        return a<<(target - 1);*/
    }
    public static void main(String[] args) {
        System.out.println(JumpFloorII.Jump(20));
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/*链接：https://www.nowcoder.com/questionTerminal/d2cced737eb54a3aa550f53bb3cc19d0?orderByHotValue=0&questionTypes=000100&difficulty=00100&page=1&onlyReference=false
        来源：牛客网

        某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
        在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

        输入描述:
        输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,
        以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。


        输出描述:
        输出一个整数,表示最大的总预计消费金额
        示例1
        输入
        3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
        输出
        20*/

/*
解题思路：
       贪心算法 + 二分法查找
       对餐桌大小按从小到大排序，对每批人的消费从大到小排序
       用二分法找出符合的餐桌
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long max = 0L;

            int[] a = new int[n];
            int[] vis = new int[n]; //标记看桌子是否被占用，被占用为 1
            int[][] num = new int[m][2];
            for (int i = 0;i < n;i++){ //每个桌子承受人数
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);

            for (int i = 0;i < m;i++){
                num[i][0] = sc.nextInt();
                num[i][1] = sc.nextInt();
            }
            Arrays.sort(num, new Comparator<int[]>() { //以 m 批人的消费 从大到小排序
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });

            for (int i = 0;i < m;i++){ //遍历 m 批人
                if (a[n-1] < num[i][0]){
                    continue;
                }
                int nu = num[i][0]; //人数
                int price = num[i][1]; //价值

                //找到 nu 在 n 的位置
                int index = dic(nu,a);
                while (index < n && vis[index] == 1){
                    index++;
                }
                if (index < n){
                    max += price;
                    vis[index] = 1;
                }
            }
            System.out.println(max);
        }
    }

    private static int dic(int nu, int[] a) {
        int left = 0;
        int right = a.length-1;
        int mid = 0;
        while (left <= right){
            mid = (right+left)/2; //二分 mid = (right + left)>>1
            if (nu <= a[mid]){  //这个要小于等于才能找到最左边的，例如找到了 num == a[mid] ，那么还要继续二分，继续找左边的，直到找到最左边的
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}

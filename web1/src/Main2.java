import java.util.*;

/*
单调栈结构
链接：https://www.nowcoder.com/questionTerminal/e3d18ffab9c543da8704ede8da578b55?orderByHotValue=1&page=1&onlyReference=false
        来源：牛客网

        给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。


        输入描述:
        第一行输入一个数字 n，表示数组 arr 的长度。

        以下一行输出 n个数字，表示数组的值。


        输出描述:
        输出n行，每行两个数字 L 和 R，如果不存在，则值为-1，下标从0开始。
        示例1
        输入
        7
        3 4 1 5 6 2 7
        输出
        -1 2
        0 2
        -1 -1
        2 5
        3 5
        2 -1
        5 -1

        备注:
        1 <= n <=10000001≤n≤1000000
        -1000000 <= arr_i<= 1000000−1000000≤arri≤1000000
*/

public class Main2{
    public static void PrintIndex(int[] arr,int count){
        int[] A = new int[2];
        for(int i = 0;i < count;i++){
            if(i == 0){
                A[0] = -1;
            }
            if(i == count - 1){
                A[1] = -1;
            }
            int j = i;
            while(j >= 0 && j < count){
                j -= 1;
                if(j >= 0) {
                    if (arr[i] > arr[j]) {
                        A[0] = j;
                        break;
                    }
                }
                else {
                    A[0] = -1;
                }
            }

            //j发生变化
            j = i;
            while(j >= 0 && j < count){
                j += 1;
                if(j < count) {
                    if (arr[i] > arr[j]) {
                        A[1] = j;
                        break;
                    }
                }else {
                    A[1] = -1;
                }
            }
            System.out.println(A[0] + " " + A[1]);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for(int i = 0;i < count;i++){
            arr[i] = sc.nextInt();
        }
        PrintIndex(arr,count);
    }
}
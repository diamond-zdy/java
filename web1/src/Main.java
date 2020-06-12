import java.util.*;

//题目：数组中值出现了一次的数字
/*链接：https://www.nowcoder.com/questionTerminal/200d8d789f9f431999fac795bb094356?orderByHotValue=1&questionTypes=000100&mutiTagIds=3446&page=1&onlyReference=false
        来源：牛客网

        给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。

        输入描述:
        输入包含两行，第一行一个整数n(1 \leq n \leq 10^5)(1≤n≤10
        5
        )，代表数组arr的长度，第二行n个整数，代表数组arr,arr[i]为32位整数。


        输出描述:
        输出出现奇数次的两个数，按照从小到大的顺序。
        示例1
        输入
        4
        1 1 2 3
        输出
        2 3
        示例2
        输入
        6
        11 22 11 23 23 45
        输出
        22 45

        备注:
        时间复杂度O(n)O(n),额外空间复杂度O(1)O(1)。*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

            String n = sc.nextLine();//这里改成int会报错
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            Map<String,Integer> map = new HashMap<String, Integer>();
            for (int i = 0;i < strings.length;i++){
                if (map.containsKey(strings[i])){
                    map.remove(strings[i]);
                }else {
                    map.put(strings[i],1);
                }
            }

            Set<Map.Entry<String,Integer>> set = map.entrySet();
            int[] arr = new int[2];
            for (Map.Entry<String,Integer> en : set){
                if (arr[0] == 0){
                    arr[0] = Integer.parseInt(en.getKey());
                }else {
                    arr[1] = Integer.parseInt(en.getKey());
                }
            }

            if (arr[0] > arr[1]){
                System.out.println(arr[1] + " " + arr[0]);
            }else {
                System.out.println(arr[0] + " " + arr[1]);
            }
        }
    }
}
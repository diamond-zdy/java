import java.util.Arrays;
import java.util.Scanner;
//航线
/*链接：https://www.nowcoder.com/questionTerminal/11faa8d2900f4ce6a53194c7015a44f4?orderByHotValue=1&commentTags=C%2FC%2B%2B&toCommentId=6307916
        来源：牛客网

        “呼！！终于到了，可是接下来要怎么走才能到达楚楚街港港呢？”亮亮在醋溜港直发愁。 突然“啾”的一下，一只银色小船出现在亮亮的面前，上面坐着小精灵丹丹“又见面了，有什么可以帮助你的么？”小精灵向亮亮眨了眨眼睛，微笑着说。 “我想去楚楚街港，但我不知道要怎么走，请问你可以告诉我么？”亮亮按捺着激动的心情轻声问道。 “楚楚街港呀......那是个特别美好的地方”小精灵歪着头想了想，说“我只能告诉你大海上所有的航线，剩下的就只能靠你自己啦~” “只有所有的航线呀”，亮亮的内心再三挣扎，却又没有其他的办法。 “不管有多困难，我一定要达到楚楚街港，请你告诉我吧”亮亮坚定地对小精灵说。 小精灵欣赏地点了点头，递给亮亮一张航线图，并叮嘱道“时限是1000天，一定要到哦~”，然后如来时一般“啾”的一声，消失了。 亮亮现在迫切地想要抵达楚楚街港，请问亮亮最快能在第几天抵达楚楚街港呢？

        输入描述:
        一行包含两个整数N(2<=N<=500),M(1<=M<=2000)，用单个空格隔开。表示公有N个港，M条航线。起点为1，终点为N。
        接下来M行，每行包含五个整数P,Q(1<=P,Q<=n), K(1<=K<=1000), X,Y(0<=X,Y<=10000),代表P,Q两个港有航线并需要K天，并且该航线在第X天到第Y天天气恶劣不可通行。


        输出描述:
        一个整数，即亮亮最快能在第几天抵达楚楚街港
        示例1
        输入
        4 4<br/>
        2 1 1 7 13<br/>
        4 3 2 10 11<br/>
        1 3 8 9 12<br/>
        2 3 3 2 10
        输出
        14*/

//在无向图中从 1 到 n 最短路径
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int map[][] = new int[n+1][n+1];
        for (int i = 0;i < n+1;i++){ // 初始化所有点相互不可达为 -1
            for (int j = 0;j < n+1;j++){
                map[i][j] = -1;
            }
        }
        int[][] s = new int[n+1][n+1]; //点不可达的起始时间
        int[][] e = new int[n+1][n+1]; //点不可达的终止时间
        for (int i = 0;i < m;i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[p][q] = k; //两个港有航向则两个点双向可达，边的大小为时间
            map[q][p] = k;
            s[p][q] = x;
            s[q][p] = x;
            e[p][q] = y;
            e[q][p] = y;
        }
        System.out.println(dijkstra(map,s,e,n));
    }

    /*
    * DijStra是求最短路径的算法，算法步骤：
    * 初识集合只包括一个圆点V，然后把距离V最小的点U加入集合，再把距离距离u最小的点加入集合，如此递归，知道所有点都在集合中
    * */
    private static int dijkstra(int[][] map, int[][] s, int[][] e, int n) {
        int[] dist = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 1;i <= n;i++){
            int min = Integer.MAX_VALUE;
            int v = 1;
            for (int j = 1;j <= n;j++){ //找到下一个点
                if (!vis[j] && dist[j] < min){
                    min = dist[j];
                    v=j;
                }
            }
            vis[v] = true;
            for (int k = 1;k <= n;k++){
                if (!vis[k] && map[v][k] != -1){
                    int tmp = dist[v] + map[v][k];
                    if (tmp < s[v][k]){ //在不可达的时间前到达了
                        dist[k] = Math.min(tmp,dist[k]);
                    }else { //在不可达的市价段内到达
                        if (dist[v] > e[v][k]){ //在前往k前已经过了不可达时间
                            dist[k] = Math.min(tmp,dist[k]);
                        }else { // 在不通行的时间范围内到达，则只能暴风雨过后在出发
                            dist[k] = Math.min(dist[k],e[v][k]+map[v][k]);
                        }
                    }
                }
            }
        }
        return dist[n]+1;//dist[n]为到达n需要几天，答案是第几天
    }
}

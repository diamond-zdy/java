/*一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
        机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
        可以有多少种不同的路径从起点走到终点？


        上图是3×7大小的地图，有多少不同的路径？
        备注：m和n小于等于100
        示例1
输入

2,1
输出

1
示例2
输入

2,2
输出

2*/

public class UniquePath {
    public int uniquePaths (int m, int n){
        int[][] arr = new int[m+1][n+1];
        for (int i = 0;i < m;i++){
            arr[i][0] = 1;
        }
        for (int i = 0;i < n;i++){
            arr[0][i] = 1;
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}

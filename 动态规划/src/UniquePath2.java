/*题目描述
        继续思考题目"Unique Paths":
        如果在图中加入了一些障碍，有多少不同的路径？
        分别用0和1代表空区域和障碍
        例如
        下图表示有一个障碍在3*3的图中央。
        [
        [0,0,0],
        [0,1,0],
        [0,0,0]
        ]
        有2条不同的路径
        备注：m和n不超过100.

        示例1
        输入

        [[0,1]]
        输出

        0
        示例2
        输入

        [[1],[1]]
        输出

        0*/
public class UniquePath2 {
    public int uniquePathsWithObstacles (int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0;i < m;i++){
            if (obstacleGrid[i][0] == 1){
                arr[i][0] = 0;
            }else {
                if (i > 0){
                    if (arr[i-1][0] == 0){
                        arr[i][0] = 0;
                    }else {
                        arr[i][0] = 1;
                    }
                }else {
                    arr[i][0] = 1;
                }
            }
        }
        for (int i = 0;i < n;i++){
            if (obstacleGrid[0][i] == 1){
                arr[0][i] = 0;
            }else {
                if (arr[0][i-1] == 0){
                    arr[0][i] = 0;
                }else {
                    arr[0][i] = 1;
                }
            }
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (arr[i][j] == 1){
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }
}

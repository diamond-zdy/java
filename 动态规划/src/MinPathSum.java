/*带权值的最短路径和
题目描述
        给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，请找出路径上的所有数字之和最小的路径。
        注意：你每次只能向下或向右移动。


        示例1
        输入

        [[1,2],[5,6],[1,1]]
        输出

        8*/
public class MinPathSum {
    public int minPathSum (int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n==0){
            return 0;
        }
        for (int i = 1;i < m;i++){
            grid[i][0] = grid[i][0]+grid[i-1][0];
        }
        for (int i = 1;i < n;i++){
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}

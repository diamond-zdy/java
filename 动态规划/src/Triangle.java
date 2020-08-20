import java.util.ArrayList;
import java.util.List;

/*题目描述
        给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
        例如，给出的三角形如下：
        [[2],[3,4],[6,5,7],[4,1,8,3]]
        最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
        注意：
        如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。


        Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
        For example, given the following triangle
        [[2],[3,4],[6,5,7],[4,1,8,3]]
        The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).

        Note:
        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/
/*public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.isEmpty()){
            return 0;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //初始化
        for (int i = 0;i < triangle.size();i++){
            res.add(new ArrayList<>());
        }
        res.get(0).add(triangle.get(0).get(0));
        for (int i = 1;i < triangle.size();i++){
            int cur = 0;
            for (int j = 0;j <= i;j++){
                if (j == 0){
                    cur = res.get(i-1).get(0);
                }else if (j == i){
                    cur = res.get(i-1).get(j-1);
                }else {
                    cur = Math.min(res.get(i-1).get(j),res.get(i-1).get(j-1));
                }
                res.get(i).add(triangle.get(i).get(j)+cur);
            }
        }
        int size = triangle.size();
        int allMin = res.get(size-1).get(0);
        for (int i = 1;i < size;i++){
            allMin = Math.min(allMin,res.get(size-1).get(i));
        }
        return allMin;
    }
}*/
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
         if (triangle.isEmpty()){
             return 0;
         }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(triangle);
         int row = res.size();
        for (int i = row-2;i >= 0;i--){
            for (int j = 0;j <= i;j++){
                int cur = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j);
                res.get(i).set(j,cur);
            }
        }
        return res.get(0).get(0);
    }
}

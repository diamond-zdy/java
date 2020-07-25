import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Test {

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        System.out.print(root.val + " ");
        list.add(root.val);
        List<Integer> list1 = preorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 = preorderTraversal(root.right);
        list.addAll(list2);
        return list;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        List<Integer> list1 = postorderTraversal(root.left);
        list.addAll(list1);
        List<Integer> list2 = postorderTraversal(root.right);
        list.addAll(list2);
        list.add(root.val);

        System.out.print(root.val + " ");
        return list;
    }

    //判断两个二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q==null){
            return true;
        }
        if (p == null && q != null){
            return false;
        }else if (p != null && q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(q.right,p.right);
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return istrue(root.right,root.left);
    }
    public boolean istrue(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return istrue(node1.right,node2.left)&&istrue(node1.left,node2.right);
    }

    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                size--;
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    //二叉树最大深度
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //从前序和中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null){
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildTreetmp(preorder,inorder,0,inorder.length-1);
    }
    int preIndex = 0;
    public TreeNode buildTreetmp(int[] preorder,int[] inorder,int inbegin,int inend){
        if (inbegin > inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找root在中序序列的下标
        int rootIndex = finIndexOfInorder(inorder,inbegin,inend,preorder[preIndex]);
        preIndex++;

        root.left = buildTreetmp(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreetmp(preorder,inorder,rootIndex+1,inend);

        return root;
    }

    private int finIndexOfInorder(int[] inorder, int inbegin, int inend, int val) {
        for (int i = inbegin;i <= inend;i++){
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //平衡二叉树
    private class ReturnB{
        int depth;
        boolean isB;

        public ReturnB(int depth, boolean isB) {
            this.depth = depth;
            this.isB = isB;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBLS(root).isB;
    }

    public ReturnB isBLS(TreeNode root){
        if (root == null){
            return new ReturnB(0,true);
        }
        ReturnB left = isBLS(root.left);
        ReturnB right = isBLS(root.right);
        if (left.isB == false || right.isB == false){
            return new ReturnB(0,false);
        }
        if (Math.abs(left.depth - right.depth) > 1){
            return new ReturnB(0,false);
        }

        return new ReturnB(Math.max(left.depth,right.depth)+1,true);
    }

}


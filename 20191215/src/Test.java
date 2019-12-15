public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        int ret = binaryTree.getKLevelSize(root,3);
        System.out.println(ret);
        TreeNode find = binaryTree.find(root,'E');
        System.out.println(find);
    }
}

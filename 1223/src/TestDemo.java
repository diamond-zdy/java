public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.preOrderTraversalNor(root);
        System.out.println("==================");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        int ret = binaryTree.getSize2(root);
        System.out.println(ret);
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        ret = binaryTree.getLeafSize2(root);
        System.out.println(ret);

        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);

        ret =binaryTree.getKLevelSize(root,3);
        System.out.println(ret);
        System.out.println("================");
        binaryTree.levelOrderTraversal(root);
        System.out.println("=================");
        /*TreeNode node = binaryTree.find(root,'u');
        System.out.println(node.value);*/
        TreeNode root2 = binaryTree.buildTree
                ("abc##de#g##f###");

        binaryTree.preOrderTraversal(root2);
        System.out.println();
        binaryTree.inOrderTraversal(root2);
    }
}

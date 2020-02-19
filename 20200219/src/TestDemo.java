public class TestDemo {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        testBinaryTree.insert(19);
        testBinaryTree.insert(9);
        testBinaryTree.insert(3);
        testBinaryTree.insert(10);
        testBinaryTree.insert(14);
        testBinaryTree.insert(24);
        testBinaryTree.inorder(testBinaryTree.root);
        System.out.println();
        testBinaryTree.preOrder(testBinaryTree.root);
        System.out.println();
        testBinaryTree.remove(10);
        testBinaryTree.inorder(testBinaryTree.root);
        System.out.println();
        testBinaryTree.preOrder(testBinaryTree.root);
    }
}

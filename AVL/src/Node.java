public class Node {
    int key;
    int bf;
    Node left;
    Node right;
    Node parent;

    Node(int key,Node parent){
        this.key = key;
        this.bf = 0;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
}

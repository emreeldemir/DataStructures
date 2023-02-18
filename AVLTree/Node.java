

public class Node {
    
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    
}
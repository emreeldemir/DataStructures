
public class AVL {
    Node root;

    
    public Node rightRotate(Node node) {

        Node leftChild = node.left;
        Node temp = leftChild.right;

        leftChild.right = node;
        node.left = temp;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        leftChild.height = Math.max(getHeight(leftChild.left), getHeight(leftChild.right)) + 1;    
        
        return leftChild;
    }

    public Node leftRotate(Node node) {
        
        Node rightChild = node.right;
        Node temp = rightChild.left;

        rightChild.left = node;
        node.right = temp;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        rightChild.height = Math.max(getHeight(rightChild.left), getHeight(rightChild.right)) + 1;

        return rightChild;
    }

    public int getHeight(Node n) {
        if (n == null) {
            return 0;
        }
        return n.height;
    }
    
    public int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return getHeight(n.left) - getHeight(n.right);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } 
        else if (key > node.key) {
            node.right = insert(node.right, key);
        } 
        else {
            return node;
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        // left left case
        if (balance > 1 && key < node.left.key) {
            node = rightRotate(node);
        }

        // right right case
        if (balance < -1 && key > node.right.key) {
            node = leftRotate(node);
        }

        // left right case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
        }

        // right left case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        }

        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node currentNode) {
        if(currentNode == null)
            return;
        
        inOrder(currentNode.left);
        System.out.print(currentNode.key + " ");
        inOrder(currentNode.right);

    }


}
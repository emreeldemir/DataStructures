
public class BinarySearchTree {
    public Node root;

    

    public BinarySearchTree() {
        this.root = null;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node currentNode) {
        if(currentNode == null)
            return;
        
        System.out.print(currentNode.value + " ");
        inOrder(currentNode.left);
        inOrder(currentNode.right); 

    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node currentNode) {
        if(currentNode == null)
            return;
        
        inOrder(currentNode.left);
        System.out.print(currentNode.value + " ");
        inOrder(currentNode.right);

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node currentNode) {
        if(currentNode == null)
            return;
        
        inOrder(currentNode.left);
        inOrder(currentNode.right); 
        System.out.print(currentNode.value + " ");

    }

    public void insert(int value) {
        this.root = insert(root, value);
    }

    private Node insert(Node currentNode, int value) {
        if(currentNode == null) {
            currentNode = new Node(value);
            return currentNode;
        }

        if(value <= currentNode.value)
            currentNode.left = insert(currentNode.left, value);
        
        else
            currentNode.right = insert(currentNode.right, value);
        
        return currentNode;
        
    }

    public Node findMax(Node currentNode) {
        
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
    
        return currentNode;
    }

    public void delete(int value){
        delete(root, value);
    }
    
    private Node delete(Node currentNode, int value) {
        
    }




    
    
}
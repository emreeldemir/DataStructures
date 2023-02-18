public class App {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(1);
        bst.insert(7);

        bst.inOrder();


    }
}

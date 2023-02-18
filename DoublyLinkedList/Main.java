

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst("Lorem");
        doublyLinkedList.addLast("Ipsum");
        doublyLinkedList.addFirst("Dolor");
        doublyLinkedList.insert("Sit",2);
        doublyLinkedList.printList();
        System.out.println("-----------------");
        doublyLinkedList.delete(3);
        doublyLinkedList.printList();
        System.out.println("-----------------");
        System.out.println(doublyLinkedList.getFirstElement());
        System.out.println("-----------------");
        System.out.println(doublyLinkedList.getLastElement());
        System.out.println("-----------------");
        doublyLinkedList.update(2,"Amet");
        doublyLinkedList.printList();
        System.out.println("-----------------");

    }


}


public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst("Lorem");
        singlyLinkedList.addLast("Ipsum");
        singlyLinkedList.addFirst("Dolor");
        singlyLinkedList.insert("Sit",2);
        singlyLinkedList.printList();
        System.out.println("-----------------");
        singlyLinkedList.delete(3);
        singlyLinkedList.printList();
        System.out.println("-----------------");
        System.out.println(singlyLinkedList.getFirstElement());
        System.out.println("-----------------");
        System.out.println(singlyLinkedList.getLastElement());
        System.out.println("-----------------");
        singlyLinkedList.update(2,"Lorem");
        singlyLinkedList.printList();
        System.out.println("-----------------");


    }

}

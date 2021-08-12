package b10.DSA_danh_sach.thuc_hanh.LinkedListSimple;

public class MainMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(100);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(3,9);
        ll.add(4,9);
        ll.printList();
    }
}

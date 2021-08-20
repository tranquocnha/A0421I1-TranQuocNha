package b10.DSA_danh_sach.bai_tap.LinkedListMethod;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(7);
        System.out.println("thao tác thêm sữa xóa");
        myLinkedList.add(1,"hello");
        myLinkedList.add(2,"xin chao");
        myLinkedList.addFirst(3);
        myLinkedList.addLast("last");
        myLinkedList.remove(2);
        myLinkedList.printList();
        System.out.println(myLinkedList.size());
        System.out.println("đây là kết quả sau khi xóa phần tử vad trả về giá trị");
        System.out.println(myLinkedList.removeElement(7));
        System.out.println(myLinkedList.contains("last"));
        myLinkedList.printList();

        System.out.println(myLinkedList.indexOf(3));
//        System.out.println(myLinkedList.addElement(7));
        System.out.println(myLinkedList.get(2));
    }
}

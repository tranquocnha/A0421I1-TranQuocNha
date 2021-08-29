package b10.DSA_danh_sach.bai_tap.LinkedListMethod;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 1;

    public MyLinkedList() {
        numNodes = 0;
        head = null;
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public void add(int index, Object data) {
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't corrent");
        }
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public void remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't corrent");
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    public E removes(int index) {
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " don't corrent");
        }

        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        E element = (E) temp.next.data;
        temp.next = temp.next.next;
        numNodes--;
        return element;
    }

    public boolean removeElement(Object element) {
        Node temp = head;
        int index = 0;
        while (temp.next != null) {
            if (temp.data != element) {
                temp = temp.next;
            } else {
                remove(index - 1);
                return true;
            }
            index++;
        }
        numNodes++;
        return false;
    }

    public int size() {
        Node temp = head;
        int size = 1;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public MyLinkedList clone() {

        return this;
    }

    public boolean contains(Object o) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        Node temp = head;
        int index = 0;
        while (temp.next != null) {
            if (temp.data == o) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean addElement(Object o) {
        if (contains(o) == false) {
            addLast(o);
            numNodes++;
            return true;
        }
        return false;
    }

    public Object get(int index) {
        Node temp = head;
        int i = 0;
        while (i <= index) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
            i++;
        }
        return "không nằm trong danh sách";
    }

    public Object getFirst() {
        Node temp = head;
        return temp.data;
    }

    public Object getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void printList() {
        MyLinkedList.Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void clear(Object data) {
        head = new Node(data);
        numNodes = 1;
    }
}

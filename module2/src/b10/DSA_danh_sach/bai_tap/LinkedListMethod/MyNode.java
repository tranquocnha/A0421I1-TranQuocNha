package b10.DSA_danh_sach.bai_tap.LinkedListMethod;

public class MyNode {
    private MyNode next;
    private Object data;

    public MyNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public MyNode getNext() {
        return next;
    }
}

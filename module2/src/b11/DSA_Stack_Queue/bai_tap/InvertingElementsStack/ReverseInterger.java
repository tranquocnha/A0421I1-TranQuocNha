package b11.DSA_Stack_Queue.bai_tap.InvertingElementsStack;

import java.util.Stack;

public class ReverseInterger {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<Integer>();
        for (int i = 0; i < 9; i++) {
            list.push(i);
        }
        System.out.println("mang ban dau: " + list);
        Stack<Integer> stack = new Stack<Integer>();
        while (list.size() > 0) {
            stack.push(list.remove(0));
        }
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        System.out.println("mang sau khi dao " + list);
    }
}

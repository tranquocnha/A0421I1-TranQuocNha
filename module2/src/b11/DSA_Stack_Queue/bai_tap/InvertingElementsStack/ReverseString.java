package b11.DSA_Stack_Queue.bai_tap.InvertingElementsStack;

import java.util.Stack;

public class ReverseString {
    public static void reverse(StringBuilder string) {
        int n = string.length();
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            stack.push(string.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            char ch = (char) stack.pop();
            string.setCharAt(i, ch);
        }
    }
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("mE uey hnA");
        System.out.println(string);
        reverse(string);
        System.out.println("Đảo ngược string is: " + string.toString());
    }
}

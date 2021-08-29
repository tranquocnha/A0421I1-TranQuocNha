package b11.DSA_Stack_Queue.bai_tap.Optional.StackKiemTraNgoac;

import java.util.Stack;

public class CheckBrackets {
    public static boolean checkBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        if (string.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < string.length(); i++) {
                char current = string.charAt(i);
                if (current == '{' || current == '(' || current == '[') {
                    stack.push(current);
                } else if (current == '}' || current == ')' || current == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char first = stack.peek();
                        if (current == '}' && first == '{' || current == ')' && first == '(' || current == ']' && first == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(checkBrackets("–b+(b^2}–4*a*c^0.5/2*a"));
    }
}

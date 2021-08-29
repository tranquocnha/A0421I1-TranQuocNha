package b11.DSA_Stack_Queue.bai_tap.Optional.Palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào chuỗi kiểm tra đối xứng");
        String string = scanner.nextLine();
        Queue queue = new LinkedList();
        for (int i = string.length() - 1; i >= 0; i--) {
            queue.add(string.charAt(i));
        }
        String reverseString = "";
        while (!queue.isEmpty()){
            reverseString=reverseString + queue.remove();
        }
        if (string.equals(reverseString)){
            System.out.println("chuỗi đối xứng");
        }else {
            System.out.println("đây không phải là chuỗi đối xứng");
        }
    }
}

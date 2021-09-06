package b13.thuat_toan_tim_kiem.bai_tap.Optional;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        System.out.println("nhâp chuỗi: ");
        String string = sc.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character elemnt : max
        ) {
            System.out.printf("%s ",elemnt);
        }
        System.out.println();
    }
}

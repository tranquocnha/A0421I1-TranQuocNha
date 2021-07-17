package b2.vong_lap_trong_java.bai_tap.HienThiSoNguyenTo;

import java.util.Scanner;

public class In_Snt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập lượng số nguyên tố để in ra");
        int number = scanner.nextInt();
        int count = 0, n = 2, i;
        for (; count <= number; n++) {
            boolean check = true;
            if (n == 2) {
                check = true;
            } else {
                for (i=2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                count++;
                System.out.println(n);
            }
        }
    }
}

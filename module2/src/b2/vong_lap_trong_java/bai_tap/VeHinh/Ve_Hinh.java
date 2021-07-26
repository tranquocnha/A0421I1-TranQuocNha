package b2.vong_lap_trong_java.bai_tap.VeHinh;

import java.util.Scanner;

public class Ve_Hinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight;
        int height;
        System.out.println("nhập chiều dài");
        height = scanner.nextInt();
        weight = height * 2 + 1;
        boolean check = true;
        while (check) {
            System.out.println("1.Vẽ hình chữ nhật ");
            System.out.println("2.vẽ hình tam giác vuông");
            System.out.println("3.vẽ hình tam giác vuong ngược");
            System.out.println("4.thoát");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    for (int i = 0; i < height; i++) {
                        System.out.println();
                        for (int j = 0; j < weight; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    for (int i = 0; i < height; i++) {
                        System.out.println();
                        for (int j = 0; j < weight; j++) {
                            if (j == i || j < i) {
                                System.out.print("*");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case 3:
                    for (int i = 0; i < height; i++) {
                        System.out.println();
                        for (int j = 0; j < height; j++) {
                            if (j <= j - i) {
                                System.out.print("*");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }
}

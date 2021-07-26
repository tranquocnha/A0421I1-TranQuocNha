package b3.mang_va_phuong_thuc_trong_java.bai_tap.XoaPhanTu;

import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        int size =0;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhap so luong phan tu:");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Vui long nhap k qua 20 phan tu");
            }
        } while (size > 20);
        arr = new int[size];
        int n = 0;
        while (n < arr.length) {
            System.out.print("Nhap mang " + (n + 1) + " : ");
            arr[n] = scanner.nextInt();
            n++;
        }
        System.out.print("In phan tu: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        int temp;
        System.out.println("Nhap gia tri can xoa trong mang");
        temp = scanner.nextInt();
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == temp) {
                check = true;
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
            }
        }
        if (check) {
            for (int i = 0; i < arr.length-1; i++) {
                System.out.print(arr[i] + "\t");
            }
        } else {
            System.out.println("so nay khong nam trong mang");
        }
    }
}

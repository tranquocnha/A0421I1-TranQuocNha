package b3.mang_va_phuong_thuc_trong_java.bai_tap.ThemPhanTu;

import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        arr = new int[soluongMang()];
        int[] newArr = new int[arr.length + 1];
        nhapMang(arr, scanner);
        inMang(arr);
        System.out.println("nhap so can chen");
        int num = scanner.nextInt();
        System.out.println("nhap vi tri can chen");
        int index = scanner.nextInt();
        themPhamTu(arr, newArr, index, num);
    }

    public static int soluongMang() {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhap so luong phan tu:");
            n = scanner.nextInt();
            if (n > 20) {
                System.out.println("Vui long nhap k qua 20 phan tu");
            }
        } while (n > 20);
        return n;
    }

    public static void nhapMang(int[] array, Scanner scanner) {
        int n = 0;
        while (n < array.length) {
            System.out.print("Nhap mang " + (n + 1) + " : ");
            array[n] = scanner.nextInt();
            n++;
        }
    }

    public static void inMang(int[] arr) {
        System.out.print("In phan tu: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }

    public static void themPhamTu(int[] arr, int[] arrNew, int index, int number) {
        for (int i = 0; i < arrNew.length; i++) {
            if (index == i) {
                arrNew[index] = number;
                break;
            } else {
                arrNew[i] = arr[i];
            }
        }
        for (int index2 = index + 1; index2 < arrNew.length; index2++) {
            arrNew[index2] = arr[index2 - 1];
        }
        for (int i = 0; i <= arrNew.length; i++) {
            System.out.print(arrNew[i] + "\t");
        }
    }
}

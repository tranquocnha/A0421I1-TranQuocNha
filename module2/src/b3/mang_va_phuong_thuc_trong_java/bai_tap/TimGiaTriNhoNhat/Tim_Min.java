package b3.mang_va_phuong_thuc_trong_java.bai_tap.TimGiaTriNhoNhat;

import java.util.Scanner;

public class Tim_Min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        arr = new int[soluongMang()];
        nhapMang(arr,scanner);
        inMang(arr);
        System.out.print("\n"+"phan tu nho nhat trong mang la: "+timMin(arr));
    }
    public static int soluongMang (){
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("\n"+"Nhap so luong phan tu:");
            n = scanner.nextInt();
            if (n > 20) {
                System.out.print("Vui long nhap k qua 20 phan tu");
            }
        } while (n > 20);
        return n;
    }
    public static void nhapMang(int[] array,Scanner scanner){
        int n = 0;
        while (n < array.length) {
            System.out.print("Nhap mang " + (n + 1) + " : ");
            array[n] = scanner.nextInt();
            n++;
        }
    }
    public static void inMang(int[] arr ){
        System.out.print("In phan tu: "+"\n");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
    public static int timMin(int[] arr){
        int min=arr[0];
        for (int i=1;i<arr.length;i++){
            if (min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
}

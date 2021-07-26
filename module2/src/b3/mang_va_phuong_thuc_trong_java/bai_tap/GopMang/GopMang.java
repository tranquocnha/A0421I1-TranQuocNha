package b3.mang_va_phuong_thuc_trong_java.bai_tap.GopMang;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1;
        int[] arr2;
        arr1 = new int[soluongMang()];
        nhapMang(arr1,scanner);
        inMang(arr1);
        arr2 = new int[soluongMang()];
        nhapMang(arr2,scanner);
        inMang(arr2);
        System.out.println("");
        gopMang(arr1,arr2);
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
            System.out.print("Nhap mang " + (n + 1) + " : "+"\n");
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
    public static void gopMang(int[] arr,int[] arr1){
        int[] arr3=new int[arr.length+arr1.length];
        for (int i=0;i<arr.length;i++){
            arr3[i]=arr[i];
        }
        for (int j=0;j<arr1.length;j++){
            arr3[arr.length+j]=arr1[j];
        }
        for (int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+"\t");
        }
    }
}

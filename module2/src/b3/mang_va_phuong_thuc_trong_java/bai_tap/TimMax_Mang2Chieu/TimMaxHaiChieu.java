package b3.mang_va_phuong_thuc_trong_java.bai_tap.TimMax_Mang2Chieu;

import java.util.Scanner;

public class TimMaxHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = soluongHang(scanner);
        int col = soluongCot(scanner);
        int[][] arr = new int[row][col];
        nhapMangHaiChieu(arr,row,col,scanner);
        inMang(arr,row,col);
        timMax(arr,row,col);
    }
    public static int soluongHang(Scanner scanner){
        int n;
        do {
            System.out.print("Nhap so luong hang:");
            n = scanner.nextInt();
            if (n > 20) {
                System.out.print("Vui long nhap k qua 20 phan tu");
            }
        } while (n > 20);
        return n;
    }
    public static int soluongCot(Scanner scanner){
        int n;
        do {
            System.out.print("Nhap so luong cot:");
            n = scanner.nextInt();
            if (n > 20) {
                System.out.print("Vui long nhap k qua 20 phan tu");
            }
        } while (n > 20);
        return n;
    }
    public static void nhapMangHaiChieu(int[][] arr,int row,int col,Scanner scanner){
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print("nhap phan tu "+(i+1)+" thu"+(j+1));
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public static void inMang(int[][] arr,int row,int col){
        System.out.print("In phan tu: "+"\n");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(arr[i][j] + "\t");
            }
        }
    }
    public static void timMax(int[][] arr,int row,int col){
        int max=arr[0][0];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (max<arr[i][j]){
                    max=arr[i][j];
                }
            }
        }
        System.out.println("\n"+"phan tu lon nhat trong mang la: "+max);
    }
}

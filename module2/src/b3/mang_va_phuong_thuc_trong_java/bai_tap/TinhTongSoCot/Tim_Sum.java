package b3.mang_va_phuong_thuc_trong_java.bai_tap.TinhTongSoCot;

import java.util.Scanner;

public class Tim_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = soluongHang(scanner);
        int col = soluongCot(scanner);
        int[][] arr = new int[row][col];
        nhapMangHaiChieu(arr,row,col,scanner);
        inMang(arr,row,col);
        System.out.println("\n nhap cot can tinh tong");
        int numberCol = scanner.nextInt();
        if(numberCol<=col){
            System.out.println("tong cac phan tu trong cot " + numberCol + " la " + totalRow(arr,numberCol));
        }else {
            System.out.println("khong tim thay cot can tinh tong trong mang");
        }

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
                System.out.print("nhap phan "+"["+(i+1)+"]"+"["+(j+1)+"]=");
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public static void inMang(int[][] arr,int row,int col){
        System.out.print("In phan tu : "+"\n");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(arr[i][j] + "\t");
            }
        }
    }
    public static int totalRow(int[][] arr,int numberCol){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][numberCol-1];
        }
        return sum;
    }
}

package b3.mang_va_phuong_thuc_trong_java.bai_tap.SoKiTu;

import java.util.Scanner;

public class SoKiTu {
    public static void main(String[] args) {
        String str="hello world";
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập một kí tự để kiểm tra số lần xuất hiện trong chuỗi");
        char check=scanner.next().charAt(0);
        int count=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==check){
                count++;
            }
        }
        System.out.println("số kí tự "+check+" xuất hiện trong chuỗi là: "+count);
    }
}

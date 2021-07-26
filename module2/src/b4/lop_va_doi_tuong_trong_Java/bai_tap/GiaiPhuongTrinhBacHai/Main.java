package b4.lop_va_doi_tuong_trong_Java.bai_tap.GiaiPhuongTrinhBacHai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PTBac2 ptBac2=new PTBac2();
        inPut(scanner,ptBac2);
        ptBac2.kiemTra();
    }
    public static void inPut(Scanner scanner,PTBac2 ptBac2){
        System.out.println("moi ban nhap puong trinh bac 2 can giai");
        System.out.println("nhap so a");
        ptBac2.setA(scanner.nextDouble());
        System.out.println("nhap so b");
        ptBac2.setB(scanner.nextDouble());
        System.out.println("nhap so c");
        ptBac2.setC(scanner.nextDouble());
    }
}

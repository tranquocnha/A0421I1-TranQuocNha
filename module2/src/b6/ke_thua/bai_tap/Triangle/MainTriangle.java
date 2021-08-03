package b6.ke_thua.bai_tap.Triangle;

import java.util.Scanner;

public class MainTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        inPut(scanner,triangle);
        System.out.println(triangle);

    }

    public static void inPut(Scanner scanner,Triangle triangle){
        System.out.println("nhap canh thu 1 tam giac: ");
        triangle.setSide1(scanner.nextDouble());
        System.out.println("nhap canh thu 2 tam giac: ");
        triangle.setSide2(scanner.nextDouble());
        System.out.println("nhap canh thu 3 tam giac: ");
        triangle.setSide3(scanner.nextDouble());
    }
}

package b8.clean_code_and_refactoring.thuc_hang.RefactoringSplitMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap bien radius");
        int radius = scanner.nextInt();
        System.out.println("nhap bien height");
        int height = scanner.nextInt();
        double result = Cylinder.getVolume(radius, height);
        System.out.println(result);
    }

}

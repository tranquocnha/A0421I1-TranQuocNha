package cassestudy.controllers;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        boolean check = true;
        int choice = 0;
        while (check) {
            System.out.println("---MENU---");
            System.out.println("1. Thêm mới bệnh án");
            System.out.println("2. Xóa bệnh án");
            System.out.println("3. Xem danh sách các bệnh án ");
            System.out.println("4. Thoát");
            System.out.print("Nhập số theo menu: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ban da nhap sai dinh dang, vui long nhap lai: ");
            }
            switch (choice) {
                case 1:
                    // them
                    break;
                case 2:
                    //sua
                    break;
                case 3:
                    // in danh sach
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        }
    }
}

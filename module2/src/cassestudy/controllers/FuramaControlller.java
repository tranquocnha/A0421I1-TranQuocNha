package cassestudy.controllers;

import cassestudy.services.Impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaControlller {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        boolean check = true;
        int choice = 0;
        while (check) {
            System.out.println("---MENU---");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Managerment");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.print("Enter a number by menu: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You enter the wrong format, please re-enter: ");
            }
            switch (choice) {
                case 1:
                    menuEmployee();
                    break;
                case 2:
                    menuCustomer();
                    break;
                case 3:
                    menuFacility();
                    break;
                case 4:
                    menuBooking();
                    break;
                case 5:
                    menuPromotion();
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        }
    }
    public static void menuEmployee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        int choice = 0;
        while (check) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.print("Enter your choice MenuEmployee: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ban da nhap sai dinh dang, vui long nhapp lai: ");
            }
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    public static void menuCustomer(){
        boolean check = true;
        while (check) {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.print("Enter your choice MenuCustomer: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    public static void menuFacility(){
        boolean check = true;
        while (check) {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.print("Enter your choice MenuCustomer: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    public static void menuBooking(){
        boolean check = true;
        int choice=0;
        while (check) {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.print("Enter your choice MenuCustomer: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ban da nhap sai dinh dang, vui long nhapp lai: ");
            }
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:

                    break;
                case 6:
                    displayMainMenu();
                    break;
            }
        }
    }
    public static void menuPromotion(){
        boolean check=true;
        int choice=0;
        while (check) {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.print("Enter your choice MenuCustomer: ");
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You enter the wrong format, please re-enter: ");
            }
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    displayMainMenu();
                    break;
            }
        }
    }
}

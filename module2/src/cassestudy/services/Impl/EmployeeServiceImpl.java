package cassestudy.services.Impl;

import cassestudy.models.Employee;
import cassestudy.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    @Override
    public void display() {

    }

    @Override
    public void addNes() {
        System.out.println("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten: ");
        String name =scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        String age = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}

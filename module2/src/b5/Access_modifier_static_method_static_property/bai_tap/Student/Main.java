package b5.Access_modifier_static_method_static_property.bai_tap.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("Nha","CO3");
//        System.out.println("Nhap ho va ten ");
//        student.setName(scanner.nextLine());
//        System.out.println("Nhap ten lop ");
//        student.setClasses(scanner.nextLine());
        System.out.println(student.toString());
        Student student1 = new Student();
        System.out.println(student1.toString());
    }
}

package b17.io_binary_file_serialization.bai_tap;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MannagerPersion {
    public static List<Persion> persions = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        persions.add(new Persion("1", "iphone x", "Apple", 1000, "Thiet ke tai tho"));
        persions.add(new Persion("2", "iphone 8", "Apple", 800, "Thiet ke sieu mong"));
        persions.add(new Persion("3", "iphone 7", "Apple", 500, "Thiet ke nho gon"));
        writeToFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b17\\io_binary_file_serialization\\bai_tap\\persion.txt", persions);
        boolean checkMenu = true;
        int choise;
        while (checkMenu) {
            System.out.println("Quản lí sản phẩm");
            System.out.println("chọn 1 để thêm sản phẩm");
            System.out.println("chọn 2 để hiển thị dấnh sách sản phẩm");
            System.out.println("chọn 3 để tìm kiếm sản phẩm");
            System.out.println("chọn 0 để thoát");
            choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    foundProduct();
                    break;
                case 0:
                    checkMenu = false;
                    break;
            }
        }
    }
    public static void addProduct() {
        System.out.println("nhap id: ");
        String id = sc.nextLine();
        System.out.println("nhap ten san pham: ");
        String nameProduct = sc.nextLine();
        System.out.println("nhap thuong hieu: ");
        String brand = sc.nextLine();
        System.out.println("nhap gia: ");
        float price = Float.parseFloat(sc.nextLine());
        System.out.println("mo ta san pham; ");
        String disription = sc.nextLine();
        Persion persion = new Persion(id, nameProduct, brand, price, disription);
        persions.add(persion);
        writeToFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b17\\io_binary_file_serialization\\bai_tap\\persion.txt", persions);

    }

    public static void writeToFile(String path, List<Persion> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Persion> readDataFromFile(String path) {
        List<Persion> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Persion>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static void showProducts() {

        for (Persion elment : readDataFromFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b17\\io_binary_file_serialization\\bai_tap\\persion.txt")) {
            System.out.println(elment.toString());
        }
    }

    public static void foundProduct() {
        System.out.println("nhap id can tim kiem:");
        String inputId = sc.nextLine();
        readDataFromFile("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b17\\io_binary_file_serialization\\bai_tap\\persion.txt");
        boolean check = false;
        for (int i = 0; i < persions.size(); i++) {
            check = false;
            String checkId = persions.get(i).getId();
            if (checkId.equals(inputId)) {
                check = true;
                System.out.println(persions.get(i));
                break;
            }
        }
        if (!check) {
            System.out.println("id nay khong ton tai");
        }
    }
}

package b12.Java_Collection_Framework.bai_tap.Framework;

import java.util.Scanner;

import static b12.Java_Collection_Framework.bai_tap.Framework.ProductManager.listProduct;

public class Main {
    public static void main(String[] args) {

        Product product = new Product(1, "iphone", "apple", 1000);
        listProduct.add(product);
        ProductManager productManager = new ProductManager();
        showMenu(productManager);
    }

    public static void showMenu(ProductManager productManager) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---MENU---");
            System.out.println("1. Thêm mới ");
            System.out.println("2. Sửa ");
            System.out.println("3. Xóa ");
            System.out.println("4. Sắp xếp tăng dần");
            System.out.println("5. Sắp xếp giảm dần ");
            System.out.println("6. Hiển thị danh sach ");
            System.out.println("7. Tìm kiếm theo Tên");
            System.out.println("0. Thoát");
            System.out.print("Nhập số theo menu: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    productManager.add();
                    break;
                case "2":
                    productManager.edit();
                    break;
                case "3":
                    productManager.delete();
                    break;
                case "4":
                    productManager.sortProductByPrice();
                    break;
                case "5":
                    productManager.sortProductByPriceDecrease();
                    break;
                case "6":
                    productManager.show();
                    break;
                case "7":
                    productManager.searchByName();
                    break;
                case "0":
                    System.out.println("exited!");
                    System.exit(0);
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }

        }
    }
}

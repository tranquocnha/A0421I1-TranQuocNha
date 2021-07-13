package b1.introduction_to_java.thuc_hang.TinhNgayTrongThanh;

import java.util.Scanner;

public class Tinh_Ngay_Trong_Thang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("bạn có muốn biết tháng này có bao nhiêu ngày không?");
        int month=scanner.nextInt();
        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }

        if (!daysInMonth.equals("")) {
            System.out.printf("The month '%d' has %s days!", month, daysInMonth);
        }
        else System.out.print("Invalid input!");
    }
}
package b1.introduction_to_java.bai_tap.ChuyenDoiTienTe;
import java.util.Scanner;
public class chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double vnd=23000;
        double usd;
        System.out.println("nhập số tiền USD cần chuyển sang VND");
        double input=scanner.nextDouble();
        usd=vnd*input;
        System.out.println("số tiền sang VND là: "+usd);
    }
}

package demo;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Tong_Client {
    public static void main(String[] args)throws IOException {
        try {
            Socket client1 = new Socket("192.168.1.2",900);
            Socket client2 = new Socket("192.168.1.2",901);
            System.out.println("Client da ket noi voi server");
            Scanner sc = new Scanner(System.in);
            PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
            Scanner in1 = new Scanner(client1.getInputStream());
            PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);
            Scanner in2 = new Scanner(client2.getInputStream());
            System.out.println("Nhap vao a, b, (cach nhau boi \";\"): ");
            String input1 = sc.nextLine();
            System.out.println("Nhap vao c, d, (cach nhau boi \";\"): ");
            String input2 = sc.nextLine();
            out1.println(input1);
            out2.println(input2);
            double S = 2*in1.nextDouble()+4*in2.nextDouble();
            System.out.println("Tong là:"+S);
            //B3 Trao doi du lieu

        } catch (IOException e) {
            System.out.println("client khong ket noi duoc");
        }
    }
}

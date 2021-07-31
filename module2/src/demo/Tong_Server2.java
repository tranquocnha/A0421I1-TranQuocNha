package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Tong_Server2 {
    public static void main(String[] args)throws IOException {
        try (
                ServerSocket server = new ServerSocket(900)) {
            System.out.println(" Server1 da khoi dong...");

            //B2: Thuc hien lang nghe va ket noi
            try (
                    Socket client = server.accept()) {
                System.out.println(" Da ket noi thanh cong voi Client...");

                //B3 : khai bao doi tuong


                try (PrintWriter out = new PrintWriter(client.getOutputStream(), true))
                {
                    Scanner in = new Scanner (client.getInputStream());
                    String st = in.nextLine();
                    String arr[]=st.split(";");
                    int c,d;
                    c=Integer.parseInt(arr[0]);
                    d=Integer.parseInt(arr[1]);
                    int ketqua =(int)(7*c+8*d);
                    out.write(ketqua);
                    out.write("\n");
                    out.flush();

                    in.close();
                    out.close();
                }

                server.close();
            }
        }
    }
}

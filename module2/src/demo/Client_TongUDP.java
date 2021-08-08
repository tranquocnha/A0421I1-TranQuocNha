package demo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Client_TongUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ClientSocket = new DatagramSocket();
        System.out.println("Da ket noi den Server");

        //B2 :Doc du lieu tu System.in khi nhap 2so nguyen a va b
        DataInputStream inFromUser = new DataInputStream(System.in);
        int a, b,c,d;

        try {
            System.out.println("Nhap vao a, b,c,d (cach nhau boi \";\"): ");
            String st = inFromUser.readLine();

            //B3 Khai bao mang byte de chua du lieu gui di server
            byte outToServer[];
//            //chuyen kieu du lieu : Tu int -> String
//            String s1 = String.valueOf(st);
            //chuyen kieu du lieu : String -> byte va dua vao mang byte da khai bao o tren
            outToServer = st.getBytes();

            //lay kich thuoc cua mang
            int leng = outToServer.length;

            //B4 Dong goi du lieu de goi cho Server
            //Lay dia chi may chu
            InetAddress address = InetAddress.getByName("Localhost");
            // Tao so port
            int port1 = 888;

            // Tao so port
            int port2= 889;

            // tao package de goi
            DatagramPacket toServer1 = new DatagramPacket(outToServer, leng, address, port1);
            DatagramPacket toServer2 = new DatagramPacket(outToServer, leng, address, port2);

            // B5 : gui package len server
            ClientSocket.send(toServer1);
            ClientSocket.send(toServer2);

            //B6 :tao package de nhan du lieu tu Server goi ve
            byte inFromServer1[];
            byte inFromServer2[];
            inFromServer1 = new byte[256];
            inFromServer2 = new byte[256];
            //kich thuoc mang nhan du lieu ve
            int leng1 = inFromServer1.length;
            int leng2 = inFromServer2.length;
            // tao package nhan du lieu ve
            DatagramPacket fromServer1 = new DatagramPacket(inFromServer1, leng1);
            DatagramPacket fromServer2 = new DatagramPacket(inFromServer2, leng2);
            // nhan package tra ve tu server
            ClientSocket.receive(fromServer1);
            ClientSocket.receive(fromServer2);
            //B7: Hien thi ket qua len man hinh
            //khai bao bien de chuyen tu kieu byte sang kieu String
            String data1,data2;

            // dua du lieu tu mang byte vao bien data, lay tu vi tri so 0.
            data1 = (new String(fromServer1.getData(), 0, fromServer1.getLength())).trim();
            data2 = (new String(fromServer2.getData(), 0, fromServer2.getLength())).trim();

            //chuyen doi tu String sang int
            int ketqua1 = Integer.parseInt(data1);
            int ketqua2 = Integer.parseInt(data2);
            //in ket qua ra man hinh
            System.out.println("25*(a+b) – 6*( 3c- 2d )= " + (25*ketqua1-6*ketqua2));

            //B8: Dong Socket
            ClientSocket.close();

        } catch (UnknownHostException e) {
            System.out.println("Server khong tim thay");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Khong the ket noi den Server");
            System.exit(1);
        }
    }
}

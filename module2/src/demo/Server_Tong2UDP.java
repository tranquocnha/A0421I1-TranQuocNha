package demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server_Tong2UDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(889);
        System.out.println("sever dang san sang:");

        //B2 tao mang kieu byte de gui len client
        byte inFromClient[] = new byte[256];
        // lay kich thuoc mang
        int leng = inFromClient.length;


        // tao gui de nhan du lieu gui tu client
        DatagramPacket formClient = new DatagramPacket(inFromClient,leng);

        //B3 nhan goi tu client goi ve sever
        serverSocket.receive(formClient);


        //B4 tao bien data kieu string de lay du lieu
        String data;
        // lay du lieu vao bien data
        data = (new String(formClient.getData(),0,inFromClient.length)).trim();

        String st = data;
        String arr[]=st.split(";");
        // chuyen du lieu tu kieu String -> integer
        int c,d,tong;
        c = Integer.parseInt(arr[2]);
        d = Integer.parseInt(arr[3]);

        tong = 3*c+4*d;
        //B5 chuyen du lieu tu int -> string
        data = String.valueOf(tong);

        byte outToClient[] = data.getBytes();

        leng = outToClient.length;

        InetAddress address = formClient.getAddress();

        int port = formClient.getPort();

        DatagramPacket toClient = new DatagramPacket(outToClient,leng,address,port);

        serverSocket.send(toClient);
    }
}

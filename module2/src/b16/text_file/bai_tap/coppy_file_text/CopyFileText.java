package b16.text_file.bai_tap.coppy_file_text;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        InputStream inStream=null;
        OutputStream outStream=null;
        try {
            inStream=new FileInputStream("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b16\\text_file\\bai_tap\\coppy_file_text\\source.txt");
            outStream=new FileOutputStream("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\b16\\text_file\\bai_tap\\coppy_file_text\\target.txt");
            int length;
            byte[] buffer=new byte[1024];
            while ((length=inStream.read(buffer))>0){
                outStream.write(buffer,0,length);
            }
            System.out.println("File is copied successful!");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            inStream.close();
            outStream.close();
        }
    }
}

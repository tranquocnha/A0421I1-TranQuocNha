package cassestudy.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ReadAndWrite {
    public static void write(Collection collection, String pathFile) {
        File file = new File(pathFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(collection);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static Object read(String pathFile) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        Object object = null;

        try {
            fileInputStream = new FileInputStream(pathFile);
            objectInputStream=new ObjectInputStream(fileInputStream);

            object=objectInputStream.readObject();

            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("file rong khong the hien thi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

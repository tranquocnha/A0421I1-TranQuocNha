package demo.demofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static final String COMMA_DELIMITER = ",";


    public static void writeFile(Collection collection, String path) {
        File file = new File(path);
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

    public static Object readCSV(String positon) {
        BufferedReader bReader = null;
        Object oject = null;
        try {
            String line;
            bReader = new BufferedReader(new FileReader(positon));
            while ((line = bReader.readLine()) != null) {
                oject = parseCsvLine(line);
            }
            return oject;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bReader != null)
                    bReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }


    public static boolean checkPhone(String phoneNumber) {


        String phoneRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pat = Pattern.compile(phoneRegex);
        Matcher matcher = pat.matcher(phoneNumber);
        if (matcher.find())
            return true;
        return false;
    }


    public static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        Matcher matcher = pat.matcher(email);
        if (matcher.find())
            return true;
        return false;
    }


    public static void printStudent(ArrayList<String> student) {
        List<String> errorList = new ArrayList<>();
        for (int i = 0; i < student.size(); i++) {
            if (checkPhone(student.get(2)) == false) {
                errorList.add("\n error phone line : " + student.get(2) + "\n");
            }
            if (checkEmail(student.get(3)) == false) {
                errorList.add("\n error email line " + student.get(i) + "\n");
            }
        }
        writeFile(errorList, "E:/error.txt");
        System.out.println(student.get(0) + ", " + student.get(1) + ", " + student.get(2) + ", " + student.get(3)
                + ", " + student.get(4));
    }


    public static Object read(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;


        Object object = null;


        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);


            object = objectInputStream.readObject();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> result = (List<String>) readCSV("D:\\A0421I1_Tran_Quoc_Nha\\A0421I1-TranQuocNha\\module2\\src\\demo\\demofile\\STD.csv");
        for(String s : result){
            System.out.println(s.toString());
        }
    }
}
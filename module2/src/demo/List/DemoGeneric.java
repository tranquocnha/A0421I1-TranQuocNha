package demo.List;


import b5.Access_modifier_static_method_static_property.bai_tap.Student.Student;

import java.util.Objects;

public class DemoGeneric {
    public static void main(String[] args) {
        Integer[] arrInt = new Integer[5];
        arrInt[0] = 1; arrInt[1] = 5; arrInt[2] = 7; arrInt[3] = 8; arrInt[4] = 9;

        String[] arrStr = new String[5];
        arrStr[0] = "Nam1"; arrStr[1] = "Nam2"; arrStr[2] = "Nam3"; arrStr[3] = "Nam4";
        arrStr[4] = "Nam5";

        Student[] students = new Student[5];
        // int => Integer
//        Integer a = 128;
//        Integer b = 127;
//        if (a == 128) {
//            System.out.println("Equals");
//        } else {
//            System.out.println("Not Equals");
//        }

//        printArrInt(arrInt);
//        printArrStr(arrStr);
        DemoGeneric.<Integer>printArr(arrInt);
        DemoGeneric.<String>printArr(arrStr);
    }

    public static void printArrInt(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArrStr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static <E> void printArr(E[] arr) {
        E[] newArr = (E[]) new Objects[arr.length];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArr1(Object[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

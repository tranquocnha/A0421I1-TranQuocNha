package b4.lop_va_doi_tuong_trong_Java.bai_tap.LopFan;

public class Main {

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(fan2.MEDIUM);
        System.out.println(fan1);
        System.out.println(fan2);
    }
}

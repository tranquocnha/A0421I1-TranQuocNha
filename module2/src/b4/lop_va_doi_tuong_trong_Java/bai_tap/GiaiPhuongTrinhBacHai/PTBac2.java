package b4.lop_va_doi_tuong_trong_Java.bai_tap.GiaiPhuongTrinhBacHai;

import java.util.Scanner;

public class PTBac2 {
    private double a;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double b;
    private double c;
    public PTBac2() {
    }

    public PTBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public double getB(){
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        double delta;
        delta=Math.pow(getB(),2)-4*getA()*getC();
        return delta;
    }
    public double getRootDouble(){
        double x1;
        x1=-getB()/(2*getA());
        return x1;
    }
    public double getRootOnly(){
        double x1;
        x1=-getC()/getB();
        return x1;
    }
    public double getRoot1(){
        double x1;
        x1=((-getB()+Math.sqrt(getDiscriminant()))/(2*getA()));
        return x1;
    }
    public double getRoot2(){
        double x1;
        x1=((-getB()-Math.sqrt(getDiscriminant()))/(2*getA()));
        return x1;
    }
    public void kiemTra(){
        if (getA()==0){
            if (getB()==0){
                System.out.println("phương trình vô nghiệm");
            }else {
                System.out.println("phương trình có nghiệm duy nhất: "+getRootOnly());
            }
        }else {
            if (getDiscriminant()<0){
                System.out.println("phương trình vô nghiệm");
            }else {
                if (getDiscriminant()==0){
                    System.out.println("phương trình có nghiệm kép: "+getRootDouble());
                }else {
                    System.out.println("phương trình có hai nghiệm phân biệt");
                    System.out.println("x1: "+getRoot1());
                    System.out.println("x2: "+getRoot2());
                }
            }
        }
    }
}

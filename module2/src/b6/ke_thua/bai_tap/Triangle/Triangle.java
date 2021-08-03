package b6.ke_thua.bai_tap.Triangle;

import b6.ke_thua.thuc_hanh.DoiTuongHinhHoc.Shape;

public class Triangle extends Shape {
    double side1=1;
    double side2=1;
    double side3=1;
    public Triangle(){}

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        double p = (float)(side1+side2+side3)/2;
        return (float)Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    public double getPerimeter(){
        double perimeter = side1+side2+side3;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Color: "+getColor()+" Area: "+getArea()+" Perimeter: "+getPerimeter();
    }
}

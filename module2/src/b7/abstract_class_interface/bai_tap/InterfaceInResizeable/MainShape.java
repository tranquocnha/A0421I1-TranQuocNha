package b7.abstract_class_interface.bai_tap.InterfaceInResizeable;

import b6.ke_thua.thuc_hanh.DoiTuongHinhHoc.Circle;
import java.awt.*;

public class MainShape {
    public static void main(String[] args) {
        Circle2 circle2 = new Circle2(3.5);
        Rectangle2 rectangle2 = new Rectangle2();
        Square2 square2 = new Square2();
        double[] shapeTests = new double[3];
        System.out.println("day la kich thuoc cua doi tuong khi chua thay doi hinhkich thuoc");
        shapeTests[0] = circle2.getArea();
        shapeTests[1] = rectangle2.getArea();
        shapeTests[2] = square2.getArea();
        for (double a : shapeTests) {
            System.out.println(a);
        }
        double[] shapeTests1 = new double[3];
        System.out.println("day la kich thuoc cua doi tuong khi da thay doi hinh kich thuoc");
        circle2.rezise(Math.random()*99+1);
        rectangle2.rezise(Math.random()*99+1);
        square2.rezise(Math.random()*99+1);
        System.out.println(circle2.getRadius());
        System.out.println(rectangle2.getHeight()+rectangle2.getWidth());
        System.out.println(square2.getSide());

    }
}

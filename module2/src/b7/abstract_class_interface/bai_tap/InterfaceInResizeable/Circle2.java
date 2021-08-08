package b7.abstract_class_interface.bai_tap.InterfaceInResizeable;

import b6.ke_thua.thuc_hanh.DoiTuongHinhHoc.Circle;

public class Circle2 extends Circle implements Resizeable {
    public Circle2(double a){}

    @Override
    public void rezise(double percent) {
        this.setRadius(this.getRadius()+this.getRadius()*percent/100);

    }
}

package b7.abstract_class_interface.bai_tap.InterfaceInResizeable;

import b4.lop_va_doi_tuong_trong_Java.thuc_hanh.Rectangle;

public class Rectangle2  extends Rectangle implements Resizeable {
    @Override
    public void rezise(double percent) {
        this.setWidth(this.getWidth()+this.getWidth()*percent/100);
        this.setHeight(this.getHeight()+this.getHeight()*percent/100);
    }
}

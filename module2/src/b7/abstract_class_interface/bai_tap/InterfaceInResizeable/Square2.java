package b7.abstract_class_interface.bai_tap.InterfaceInResizeable;

import b6.ke_thua.thuc_hanh.DoiTuongHinhHoc.Square;

public class Square2 extends Square implements Resizeable {
    @Override
    public void rezise(double percent) {
        this.setSide(this.getSide()+this.getSide()*percent/100);
    }
}

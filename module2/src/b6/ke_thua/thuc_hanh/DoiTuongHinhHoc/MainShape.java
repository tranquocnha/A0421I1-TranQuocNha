package b6.ke_thua.thuc_hanh.DoiTuongHinhHoc;

public class MainShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}

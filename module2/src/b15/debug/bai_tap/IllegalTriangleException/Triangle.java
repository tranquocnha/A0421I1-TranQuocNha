package b15.debug.bai_tap.IllegalTriangleException;

public class Triangle {
    private int side1;
    private int side2;
    private int side3;
    public Triangle(int side1,int side2,int side3)throws IllegalTriangleException{
        if (side1<=0||side2<=0||side3<=0){
            throw new IllegalTriangleException("Đây khôgn ohai là ba cạnh của tam giác, giá trị phải là số nguyên dương");

        }else if ((side1+side2)<side3||(side1+side3)<side2||(side2+side3)<side1){
            throw new IllegalTriangleException("Đây khong phải là 3 cạnh của tam giác. Tỏng của hai cạnh phải lớn hơn cạnh còn lại!!");

        }else {
            this.side1=side1;
            this.side2=side2;
            this.side3=side3;
        }
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}

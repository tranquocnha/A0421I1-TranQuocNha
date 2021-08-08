package b7.abstract_class_interface.bai_tap.InterfaceColorable;

public class MainSquare {
    public static <square> void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle1 = new Rectangle(8,9,"green",false);
        Square square1=new Square(3.5,"blue",true);

        Rectangle[] arr = {rectangle,square1,rectangle1};
        for ( Rectangle shape:arr){
            System.out.println(shape);
            if (shape.getColor() instanceof String ){
                shape.howToColor();
            }
        }
    }
}

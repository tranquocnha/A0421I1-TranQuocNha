package b7.abstract_class_interface.bai_tap.InterfaceColorable;

public class MainSquare {
    public static  void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle1 = new Rectangle(8,9,"green",false);
        Square square1=new Square(3.5,"blue",true);

       Rectangle[] arr = {rectangle,square1,rectangle1};
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//                arr[i].howToColor();
//        }

        for ( Rectangle shape:arr){
            System.out.println(shape);
            if (shape instanceof Square ){
                shape.howToColor();
            }
        }
    }
}

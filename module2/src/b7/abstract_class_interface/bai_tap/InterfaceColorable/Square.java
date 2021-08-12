package b7.abstract_class_interface.bai_tap.InterfaceColorable;


public class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void howToColor() {
        System.out.println("A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString()
                + "Color all four sides");
    }
}

package b5.Access_modifier_static_method_static_property.thuc_hanh.StaticProperty;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    public Car(){

    }
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
}

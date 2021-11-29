package codegym.model;

public class Product {
    private int productId;
    private String productName;
    private String brand;
    private String color;
    private double price;

    public Product() {
    }

    public Product(int productId, String productName, String brand, String color, double price) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package cassestudy.models;

public class Customer extends Person {
    private String typeCustomer;

    public Customer() {
    }

    public Customer(int id, String name, int age, String address, String gender, int phoneNumber, String email, String typeCustomer) {
        super(id, name, age, address, gender, phoneNumber, email);
        this.typeCustomer = typeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return  super.toString()+"Customer{" +
                "typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}

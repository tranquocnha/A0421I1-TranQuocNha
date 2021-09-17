package cassestudy.models;

public class Customer extends Person {

    private String typeCustomer;

    public Customer() {
    }

    public Customer(String id, String name, int age, String address, String gender, int phoneNumber, String email, String typeCustomer) {
        super(id, name, age, address, gender, phoneNumber, email);
        this.typeCustomer = typeCustomer;
    }

    public Customer(String id, String name, int age, String address, String gender, int phoneNumber, String email, String customerId, String typeCustomer) {
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
        return  "Customer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", email='" + getEmail() + '\'' +
                "typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}

package cassestudy.models;

public class Employee extends Person {
    private String position;
    private int salary;

    public Employee() {
    }
    public Employee(String position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    public Employee(String id,
                    String name,
                    int age,
                    String address,
                    String gender,
                    int phoneNumber,
                    String email,
                    String position,
                    int salary) {
        super(id, name, age, address, gender, phoneNumber, email);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", email='" + getEmail() + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

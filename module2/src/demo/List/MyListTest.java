package demo.List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Person> personList = new MyList<>();
        personList.add(new Person());
        personList.add(new Person());
        personList.add(new Person());
        personList.add(new Person());
        personList.add(new Person());

        MyList<Person> list2 = personList.clone();

    }
}

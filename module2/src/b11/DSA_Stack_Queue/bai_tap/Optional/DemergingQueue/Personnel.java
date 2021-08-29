package b11.DSA_Stack_Queue.bai_tap.Optional.DemergingQueue;

import sun.awt.OverrideNativeWindowHandle;

public class Personnel {
    protected String name;
    protected int age;
    protected String birthDay;
    protected String gender;

    public Personnel(String name, int age, String birthDay, String gender) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name: "+name+" age: "+age+" birthday: "+birthDay+" gerder: "+gender;
    }

}

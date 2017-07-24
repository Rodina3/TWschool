package practice_1;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }

    public String toString() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }
}

package practice_5;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return this.basicIntroduce();
    }

    protected String basicIntroduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";

    }
}

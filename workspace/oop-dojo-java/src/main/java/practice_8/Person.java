package practice_8;

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
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

}

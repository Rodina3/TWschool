///**
// * Created by rzhou on 2017/8/8.
// */

//case 6:自定义异常类
public class TestMyException {
    public static void main(String args[]) {
        try {
            Person p = new Person("张三", 25);
            System.out.println(p.toString());
            p.setAge(-8);
            System.out.println(p.toString());
        } catch (AgeSetException e) {
            System.out.println(e.toString());
        }
    }
}

class AgeSetException extends Exception {
    public AgeSetException(String msg) {
        super(msg);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws AgeSetException {
        if (age < 0) {
            throw new AgeSetException("异常：age=" + age + ";年龄不能小于0！");
        } else {
            this.name = name;
            this.age = age;
        }
    }

    public void setAge(int age) throws AgeSetException {
        if (age < 0) {
            throw new AgeSetException("异常：age=" + age + ";年龄不能小于0！");
        } else {
            this.age = age;
        }
    }

    public String toString() {
        return "name:" + name + "age=" + age;
    }
}

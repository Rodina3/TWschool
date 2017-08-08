///**
// * Created by rzhou on 2017/8/8.
// */

//case 6:自定义异常类
//public class TestMyException {
//    public static void main(String args[]) {
//        try {
//            Person p1 = new Person("张三", 25);
//            System.out.println(p1.toString());
//            p1.setAge(-8);
//            System.out.println(p1.toString());
//        } catch (MyException e) {
//            System.out.println(e.toString());
//        }
//    }
//}
//
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}
//
//class Person {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) throws MyException {
//        if (age < 0) {
//            throw new MyException("异常：age=" + age + ";年龄不能小于0！");
//        } else {
//            this.name = name;
//            this.age = age;
//        }
//    }
//
//    public void setAge(int age) throws MyException {
//        if (age < 0) {
//            throw new MyException("异常：age=" + age + ";年龄不能小于0！");
//        } else {
//            this.age = age;
//        }
//    }
//
//    public String toString() {
//        return "name:" + name + "age=" + age;
//    }
//}

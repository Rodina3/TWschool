package practice_4;

/**
 * Created by rzhou on 24/07/2017.
 */
public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    public String introduce() {
        return super.introduce() + " I am a Worker. I have a job.";
    }
}

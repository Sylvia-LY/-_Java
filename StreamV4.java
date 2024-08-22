import java.io.*;

class Student implements Serializable {
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name+", age: "+age+", grade: "+grade;
    }
}

public class StreamV4 {

    public static void main(String[] args) {
        try {
            Student s1 = new Student("Alice", 20, 85);
            System.out.println(s1);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            out.writeObject(s1);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.dat"));
            Student s2 = (Student)in.readObject();
            System.out.println(s2);
            in.close();


            // 这两个对象里面的内容是一样的，但是她们并不是相同的对象
            System.out.println(s1==s2);

        }
        catch ( IOException| ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
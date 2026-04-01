package review.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person  {
    private String className;

    public Student(String name, String email, LocalDate birthday, String className) {
        super(name, email, birthday);
        this.className = className;
    }

    public Student(int id, String name, String email, LocalDate birthday, String className) {
        super(id, name, email, birthday);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                "} " + super.toString();
    }

    @Override
    public String toLineString() {
        return super.getId() + "," + super.getName() + "," + super.getEmail() + "," + super.getBirthday() + "," + className;
    }
}

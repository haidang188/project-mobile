package review.io_stream;

import review.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentIOStream {
    private static final String URL = "src/review/data/student.csv";

    public static void writeStudentIntoFile(Student student) {
        try (FileWriter fw = new FileWriter(URL, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(student.toLineString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeListStudentIntoFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(URL);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Student student : students) {
                bw.write(student.toLineString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readStudentFromFile() {
        List<Student> students = new ArrayList<>();
        try (FileReader fr = new FileReader(URL);
             BufferedReader br = new BufferedReader(fr)) {
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] data = temp.split(",");
                students.add(new Student(Integer.parseInt(data[0]), data[1],
                        data[2], LocalDate.parse(data[3]), data[4]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}

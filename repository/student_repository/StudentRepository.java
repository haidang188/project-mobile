package review.repository.student_repository;

import review.io_stream.StudentIOStream;
import review.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static int lastId;

    static {
        List<Student> students = StudentIOStream.readStudentFromFile();
        if (!students.isEmpty()) {
            lastId = students.get(students.size() - 1).getId();
        } else {
            lastId = 0;
        }
    }


    @Override
    public void save(Student student) {
        student.setId(++lastId);
        StudentIOStream.writeStudentIntoFile(student);
    }

    @Override
    public void delete(Student student) {
        List<Student> studentList = StudentIOStream.readStudentFromFile();
        for (int i = 0; i < studentList.size(); i++) {
            if (student.getId() == studentList.get(i).getId()) {
                studentList.remove(i);
                break;
            }
        }
        StudentIOStream.writeListStudentIntoFile(studentList);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student findById(int id) {
        for (Student student : StudentIOStream.readStudentFromFile()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return StudentIOStream.readStudentFromFile();
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : StudentIOStream.readStudentFromFile()) {
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }
}

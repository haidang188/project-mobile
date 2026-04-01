package review.controller;

import review.model.Student;
import review.service.student_service.IStudentService;
import review.service.student_service.StudentService;

import java.util.List;

public class StudentController {
    private IStudentService iStudentService = new StudentService();

    public void findAll() {
        for (Student student : iStudentService.findAll()) {
            System.out.println(student);
        }
    }

    public void saveStudent(Student student) {
        iStudentService.save(student);
    }

    public Student findById(int id) {
        return iStudentService.findById(id);
    }

    public void delete(Student student) {
        iStudentService.delete(student);
    }

    public void searchByName(String name) {
        List<Student> students = iStudentService.searchByName(name);
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("không tồn tại");
        }

    }
}

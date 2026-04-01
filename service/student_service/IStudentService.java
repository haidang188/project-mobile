package review.service.student_service;

import review.model.Student;

import java.util.List;

public interface IStudentService {
    void save(Student student);
    void delete(Student student);
    void update(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> searchByName(String name);
}

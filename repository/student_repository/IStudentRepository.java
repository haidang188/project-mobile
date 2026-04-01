package review.repository.student_repository;

import review.model.Student;

import java.util.List;

public interface IStudentRepository {
    void save(Student student);
    void delete(Student student);
    void update(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> searchByName(String name);
}

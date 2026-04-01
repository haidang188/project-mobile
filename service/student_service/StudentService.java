package review.service.student_service;

import review.model.Student;
import review.repository.student_repository.IStudentRepository;
import review.repository.student_repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        iStudentRepository.delete(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public List<Student> searchByName(String name) {
        return iStudentRepository.searchByName(name);
    }
}

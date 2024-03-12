package services;

import java.util.List;

import domain.Student;
import persistence.StudentRepository;

public class StudentService {
    
    private final StudentRepository studentRepository;
    private final FeeService feeService;

    public StudentService() {
        this.studentRepository = new StudentRepository();
        this.feeService = new FeeService();
    }

    public void createStudent(Student student){
        if (student.getId() != null) {
            throw new IllegalArgumentException("Student ID must be null for new courses");
        }

        studentRepository.save(student);
        feeService.generateFees(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Student findStudentById(Long id){
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Long id){
        studentRepository.updateStudent(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteStudentById(id);
    }



}

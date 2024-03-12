package services;

import java.util.List;

import domain.Student;
import persistence.FeeRepository;
import persistence.StudentRepository;

public class StudentService {
    
    private final StudentRepository studentRepository;
    private final FeeService feeService;

    public StudentService() {
        this.studentRepository = new StudentRepository();
        this.feeService = new FeeService(new FeeRepository());
    }

    public void createStudent(Student student){
        Student studentAlreadyExists = studentRepository.getStudentById(student.getId());
        if(studentAlreadyExists != null){
            throw new IllegalArgumentException("Student already exists");
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

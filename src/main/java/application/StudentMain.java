package application;

import domain.Address;
import domain.Student;
import persistence.StudentRepository;

public class StudentMain {


    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
        Student newStudent = new Student();

        Address address = new Address();

        address.setCity("São Paulo");
        address.setCountry("Brazil");
        address.setPostalCode("12345678");
        address.setState("SP");
        address.setStreet("Avenida Paulista");
        address.setReferencePoint("Casa");

        try {
            student.setName("Diogo Marcelo");
            student.setEmail("dmsviana@gmail.com");
            student.setPassword("12345678");
            student.setAddress(address);

            newStudent.setName("Dener Matheus");
            newStudent.setEmail("denerviana@gmail");
            newStudent.setPassword("12345678");
            newStudent.setAddress(address);


            studentRepository.save(student);
            studentRepository.save(newStudent);
            System.out.println(studentRepository.getAllStudents());
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }

}

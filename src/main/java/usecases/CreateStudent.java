package usecases;

import domain.Address;
import domain.Student;
import services.StudentService;

public class CreateStudent {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();

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
            student.setPhoneNumber("83996586204");
            student.setRegistration("20240312");
            student.setAddress(address);

            newStudent.setName("Dener Matheus");
            newStudent.setEmail("denerviana@gmail");
            newStudent.setPassword("12345678");
            newStudent.setPhoneNumber("83996586205");
            newStudent.setRegistration("2024031");
            newStudent.setAddress(address);

            studentService.createStudent(student);
            studentService.createStudent(newStudent);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}

package usecases.students;

import java.util.logging.Level;
import java.util.logging.Logger;

import domain.Address;
import domain.Student;
import services.StudentService;

public class CreateStudent {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        StudentService studentService = new StudentService();

        Student student = new Student();
        Address address = new Address();

        address.setCity("São Paulo");
        address.setCountry("Brazil");
        address.setPostalCode("12345678");
        address.setState("SP");
        address.setStreet("Avenida Paulista");
        address.setReferencePoint("Casa");

        try {
            student.setName("Gilberto Justino");
            student.setEmail("gilberto@gmail.com");
            student.setPassword("12345678");
            student.setPhoneNumber("83996586200");
            student.setRegistration("202403180");
            student.setAddress(address);

            studentService.createStudent(student);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}

package usecases.teachers;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.Address;
import domain.Teacher;
import services.TeacherService;

public class CreateTeacher {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        TeacherService teacherService = new TeacherService();

        Teacher teacher = new Teacher();
        Address address = new Address();

        address.setCity("São Paulo");
        address.setCountry("Brazil");
        address.setPostalCode("12345678");
        address.setState("SP");
        address.setStreet("Avenida Paulista");
        address.setReferencePoint("Casa");

        try {
            teacher.setName("Cleyton");
            teacher.setEmail("cleytin@gmail.com");
            teacher.setPassword("12345678");
            teacher.setPhoneNumber("83996586250");
            teacher.setRegistration("202403190");
            teacher.setSalary(new BigDecimal(10000));
            teacher.setAddress(address);

            teacherService.createTeacher(teacher);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}

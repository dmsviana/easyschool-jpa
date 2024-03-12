package usecases;

import java.time.DayOfWeek;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.Course;
import services.CourseService;

public class CreateCourse {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
        CourseService courseService = new CourseService();
        System.out.println("=================== CRIANDO CURSO =================== \n");
        Course course = new Course();

        try {
            course.setName("StartUP");
            course.setDescription("Para crianças de 8 a 10 anos de idade.");
            course.setMaxCapacity(20);
            course.setDaysOfWeek(List.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY));
            courseService.createCourse(course);
            System.out.println("CURSO CRIADO COM SUCESSO!");
            
        } catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
    
}

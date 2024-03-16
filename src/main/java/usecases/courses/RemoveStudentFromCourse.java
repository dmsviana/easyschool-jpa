package usecases.courses;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.CourseService;

public class RemoveStudentFromCourse {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        CourseService courseService = new CourseService();
        try {

            // assumindo que o curso com id 1 já existe e que o aluno com id 1 já existe
            courseService.removeStudentFromCourse(1L, 1L);
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
    
}
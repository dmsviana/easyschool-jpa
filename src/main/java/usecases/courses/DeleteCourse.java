package usecases.courses;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.CourseService;

public class DeleteCourse {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        CourseService courseService = new CourseService();
        try {
            courseService.deleteCourse(1L);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}

package usecases.teachers;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.TeacherService;

public class RemoveCourseFromTeacher {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        TeacherService teacherService = new TeacherService();
        // CourseService courseService = new CourseService();
        try {
            // Course course = courseService.getCourseById(1L);

            // assumindo que o curso com id 1 já existe e que o professor com id 4 já existe
            teacherService.removeCourseFromTeacher(4L, 1L);
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
    
}

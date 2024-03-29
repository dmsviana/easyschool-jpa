package usecases.teachers;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.TeacherService;

public class AssociateTeacherToCourse {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        TeacherService teacherService = new TeacherService();
        
        try {
            // assumindo que o curso com id 1 já existe e que o professor com id 4 já existe
            teacherService.addCourseToTeacher(4L, 1L);
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
}

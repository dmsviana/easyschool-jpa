package usecases;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.CourseService;

public class AddStudentToCourse {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        CourseService courseService = new CourseService();

        try {
            courseService.addStudentToCourse(3L, 3L);
            System.out.println("ALUNO ADICIONADO COM SUCESSO!");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}

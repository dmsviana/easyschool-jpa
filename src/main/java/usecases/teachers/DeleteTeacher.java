package usecases.teachers;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.TeacherService;

public class DeleteTeacher {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        TeacherService teacherService = new TeacherService();

        try {
            teacherService.deleteTeacher(1L);
            System.out.println("=================== PROFESSOR DELETADO COM SUCESSO =================== \n");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
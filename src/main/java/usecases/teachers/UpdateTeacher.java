package usecases.teachers;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.TeacherService;

public class UpdateTeacher {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        TeacherService teacherService = new TeacherService();

        System.out.println(
                "=================== ATUALIZANDO PROFESSOR DE ID =================== \nINFORMAÇÕES DO MESMO ANTES DO UPDATE: \n"
                        + teacherService.findTeacherById(2L) + "\n");

        try {
            teacherService.updateTeacher(2L);
            System.out.println(
                    "=================== INFORMAÇÕES DO MESMO APÓS O UPDATE =================== \n: \n"
                            + teacherService.findTeacherById(2L));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}
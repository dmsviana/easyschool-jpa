package usecases.teachers;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.TeacherService;

public class FindTeacher {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
        TeacherService teacherService = new TeacherService();

        try {
            System.out.println("=================== LISTANDO TODOS OS PROFESSORES =================== \n" + teacherService.findAllTeachers());
            System.out.println("=================== BUSCANDO PROFESSOR PELO ID =================== \n" + teacherService.findTeacherById(2L));
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
       
    }
    
}

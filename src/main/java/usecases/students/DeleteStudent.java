package usecases.students;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.StudentService;

public class DeleteStudent {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        StudentService studentService = new StudentService();

        try {
            studentService.deleteStudent(1L);
            System.out.println("=================== ALUNO DELETADO COM SUCESSO =================== \n");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}

package usecases.students;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.StudentService;

public class UpdateStudent {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        StudentService studentService = new StudentService();

        System.out.println(
                "=================== ATUALIZANDO ALUNO DE ID =================== \nINFORMAÇÕES DO MESMO ANTES DO UPDATE: \n"
                        + studentService.findStudentById(1L) + "\n");

        try {
            studentService.updateStudent(1L);
            System.out.println(
                    "=================== INFORMAÇÕES DO MESMO APÓS O UPDATE =================== \n: \n"
                            + studentService.findStudentById(1L));
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}

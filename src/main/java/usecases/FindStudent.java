package usecases;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.StudentService;

public class FindStudent {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
        StudentService studentService = new StudentService();

        try {
            System.out.println("=================== LISTANDO TODOS OS ALUNOS =================== \n" + studentService.findAllStudents());
            System.out.println("=================== BUSCANDO ALUNO PELO ID =================== \n" + studentService.findStudentById(2L));
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        }
       




    }
    
}

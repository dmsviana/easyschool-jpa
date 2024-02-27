package persistence;

import domain.Student;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class StudentRepository extends Repository {

    public void save(Student student) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            System.out.println("Student has been created!");
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }

    }

    public Student getStudentById(UUID id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Student.class, id);
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
        return null;
    }

    public List<Student> getAllStudents(){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
        return null;
    }
}

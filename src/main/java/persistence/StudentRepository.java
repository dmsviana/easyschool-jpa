package persistence;

import java.util.List;

import domain.Student;
import jakarta.persistence.EntityManager;

public class StudentRepository extends Repository {

    public void save(Student student) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.flush();
            em.getTransaction().commit();
        } catch(Exception ex){
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        } finally {
            em.close();
        }

    }

    public Student getStudentById(Long id){
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

    public void updateStudent(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            student.setName("Henry Monteiro");
            student.setEmail("henry@gmail.com");
            em.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
    }

    public void deleteStudentById(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
    }
}

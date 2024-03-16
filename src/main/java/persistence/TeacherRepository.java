package persistence;

import java.util.List;

import domain.Teacher;
import jakarta.persistence.EntityManager;

public class TeacherRepository extends Repository {

    public void save(Teacher teacher) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
        } catch(Exception ex){
            System.out.println("Error: " + ex);
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Teacher getTeacherById(Long id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Teacher.class, id);
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
        return null;
    }

    public List<Teacher> getAllTeachers(){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
        } catch(Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
        return null;
    }

    public void updateTeacher(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Teacher teacher = em.find(Teacher.class, id);
            teacher.setName("Gilberto Justino");
            em.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
    }

    public void deleteTeacherById(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Teacher teacher = em.find(Teacher.class, id);
            em.remove(teacher);
            em.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        } finally {
            em.close();
        }
    }
}
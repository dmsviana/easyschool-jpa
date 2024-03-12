package persistence;

import java.util.List;

import domain.Course;
import jakarta.persistence.EntityManager;

public class CourseRepository extends Repository {

    public void save(Course course) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public Course getCourseById(Long id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Course.class, id);
        } catch (Exception ex){
            throw ex;
        } 
        finally {
            em.close();
        }
    }

    public List<Course> getAllCourses() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        } catch (Exception ex){
            throw ex;
        } 
        finally {
            em.close();
        }
    }

    public void updateCourse(Course course){
        EntityManager em = getEntityManager();
        try {

            if(getCourseById(course.getId()) == null){
                throw new IllegalArgumentException("Course not found");
            }

            course.setName("Nome atualizado");
            course.setMaxCapacity(50);

            em.getTransaction().begin();
            em.merge(course);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public void deleteCourse(Long id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Course course = em.find(Course.class, id);
            em.remove(course);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
}

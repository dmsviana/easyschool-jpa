package persistence;

import java.time.LocalDate;
import java.util.List;

import domain.Fee;
import jakarta.persistence.EntityManager;

public class FeeRepository extends Repository {


    public void saveAll(List<Fee> fees) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            for (Fee fee : fees) {
                em.persist(fee);
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<Fee> findOverdueFees(LocalDate date){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT f FROM Fee f WHERE f.dueDate < :date", Fee.class)
                    .setParameter("date", date)
                    .getResultList();
        } catch (Exception ex){
            throw ex;
        } 
        finally {
            em.close();
        }
    }

    public Fee getFeeById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fee.class, id);
        } catch (Exception ex){
            throw ex;
        } 
        finally {
            em.close();
        }
    }

    public List<Fee> getAllFees() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT f FROM Fee f", Fee.class).getResultList();
        } catch (Exception ex){
            throw ex;
        } 
        finally {
            em.close();
        }
    }

    public void update(Fee fee) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(fee);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    
    public void deleteById(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Fee fee = em.find(Fee.class, id);
            em.remove(fee);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
    
}

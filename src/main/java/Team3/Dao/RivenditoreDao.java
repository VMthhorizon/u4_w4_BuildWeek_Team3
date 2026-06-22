package Team3.Dao;

import jakarta.persistence.EntityManager;
import Team3.entities.Rivenditore;

import java.util.List;

public class RivenditoreDao {

    private EntityManager em;

    public RivenditoreDao(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore r) {
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
    }

    public Rivenditore findById(Long id) {
        return em.find(Rivenditore.class, id);
    }

    public List<Rivenditore> findAll() {
        return em.createQuery("SELECT r FROM Rivenditore r", Rivenditore.class).getResultList();
    }

    public void update(Rivenditore r) {
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Rivenditore r = em.find(Rivenditore.class, id);
        if (r != null) {
            em.remove(r);
        }
        em.getTransaction().commit();
    }
}
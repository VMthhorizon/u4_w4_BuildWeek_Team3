package Team3.Dao;

import jakarta.persistence.EntityManager;
import Team3.entities.PuntoDiEmissione;

import java.util.List;

public class PuntoDiEmissioneDao {

    private EntityManager em;

    public PuntoDiEmissioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(PuntoDiEmissione p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public PuntoDiEmissione findById(Long id) {
        return em.find(PuntoDiEmissione.class, id);
    }

    public List<PuntoDiEmissione> findAll() {
        return em.createQuery("SELECT p FROM PuntoDiEmissione p", PuntoDiEmissione.class).getResultList();
    }

    public void update(PuntoDiEmissione p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        PuntoDiEmissione p = em.find(PuntoDiEmissione.class, id);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }
}
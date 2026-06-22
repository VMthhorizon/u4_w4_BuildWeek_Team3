package Team3.Dao;

import jakarta.persistence.EntityManager;
import Team3.entities.Distributore;

import java.util.List;

public class DistributoreDao {

    private EntityManager em;

    public DistributoreDao(EntityManager em) {
        this.em = em;
    }

    public void save(Distributore dist) {
        em.getTransaction().begin();
        em.persist(dist);
        em.getTransaction().commit();
    }

    public Distributore findById(Long id) {
        return em.find(Distributore.class, id);
    }

    public List<Distributore> findAll() {
        return em.createQuery("SELECT d FROM Distributore d", Distributore.class).getResultList();
    }

    public void update(Distributore dist) {
        em.getTransaction().begin();
        em.merge(dist);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Distributore dist = em.find(Distributore.class, id);
        if (dist != null) {
            em.remove(dist);
        }
        em.getTransaction().commit();
    }
}
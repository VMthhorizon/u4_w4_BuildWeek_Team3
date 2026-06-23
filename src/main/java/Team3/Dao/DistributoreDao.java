package Team3.Dao;

import jakarta.persistence.EntityManager;
import Team3.entities.Distributore;

import java.util.List;
import java.util.UUID;

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

    public Distributore findById(UUID id) {
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

    public void delete(UUID id) {
        em.getTransaction().begin();
        Distributore dist = em.find(Distributore.class, id);
        if (dist != null) {
            em.remove(dist);
        }
        em.getTransaction().commit();
    }
}
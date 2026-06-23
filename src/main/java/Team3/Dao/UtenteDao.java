package Team3.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import Team3.entities.Utente;

import java.util.List;
import java.util.UUID;

public class UtenteDao {

    private EntityManager entityManager;

    public UtenteDao(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Utente u) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(u);
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Errore save: " + e.getMessage(), e);
        }
    }

    public Utente findById(UUID id) {
        return entityManager.find(Utente.class, id);
    }

    public List<Utente> findAll() {
        return entityManager.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
    }
}
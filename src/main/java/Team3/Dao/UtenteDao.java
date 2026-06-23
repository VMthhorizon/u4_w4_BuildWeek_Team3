package Team3.Dao;

import Team3.exceptions.NotFoundException;
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

    public Utente save(Utente u) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(u);
            tx.commit();
            System.out.println("L'utente: " + u.getNome() + " " + u.getCognome() + " é stato salvato");
        } catch (Exception e) {
            throw new NotFoundException("Errore save: " + e.getMessage());
        }
        return u;
    }

    public Utente findById(String id) {

        Utente utenteFromDb = entityManager.find(Utente.class, UUID.fromString(id));
        if (utenteFromDb == null) throw new NotFoundException("L'utente con id: " + id + " non é stato trovato");
        System.out.println("L' utente con id: " + id + " é stato trovato");
        return utenteFromDb;

    }

    public List<Utente> findAll() {
        return entityManager.createQuery("SELECT u FROM Utente u", Utente.class)
                .getResultList();
    }
}
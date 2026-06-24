package Team3.Dao;

import Team3.entities.Tessera;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import Team3.entities.PuntoDiEmissione;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class PuntoDiEmissioneDao {

    private final EntityManager entityManager;

    public PuntoDiEmissioneDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PuntoDiEmissione save(PuntoDiEmissione newPuntoDiEmissione) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            this.entityManager.persist(newPuntoDiEmissione);
            transaction.commit();
            System.out.println("Punto di emissione " + newPuntoDiEmissione.getNome() + ", salvato con successo");

        } catch (Exception e) {
            throw new SaveException(
                    "Errore durante il salvataggio del Punto di Emissione " + newPuntoDiEmissione.getNome() + ": " + e.getMessage());
        }
        return newPuntoDiEmissione;
    }

    public PuntoDiEmissione findById(String id) {
        PuntoDiEmissione puntoDiEmissione = this.entityManager.find(PuntoDiEmissione.class, UUID.fromString(id));
        if (puntoDiEmissione == null) {
            throw new NotFoundException("Punto di emissione con ID " + id + " non trovato.");
        }
        return puntoDiEmissione;
    }

    public List<PuntoDiEmissione> findAll() {
        return entityManager.createQuery("SELECT t FROM PuntoDiEmissione t", PuntoDiEmissione.class)
                .getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(t) FROM PuntoDiEmissione t", Long.class)
                .getSingleResult();
    }
}
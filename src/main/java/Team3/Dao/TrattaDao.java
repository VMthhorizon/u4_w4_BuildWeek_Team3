package Team3.Dao;

import Team3.entities.Tratta;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.TreeMap;
import java.util.UUID;

public class TrattaDao {
    private final EntityManager entityManager;

    public TrattaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Tratta save(Tratta newTratta) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        try {
            transaction.begin();
            this.entityManager.persist(newTratta);
            transaction.commit();
            System.out.println("Tratta " + newTratta.getIdTratta() + ", salvata con successo");

        } catch (Exception e) {
            throw new SaveException(
                    "Errore durante il salvataggio del Punto di Emissione " + newTratta.getIdTratta() + ": " + e.getMessage());
        }
        return newTratta;
    }

    public Tratta findById(String id) {
        Tratta tratta = this.entityManager.find(Tratta.class, UUID.fromString(id));
        if (tratta == null) {
            throw new NotFoundException("Tratta con ID " + id + " non trovato.");
        }
        System.out.println("La tratta con ID: " + id + " é stata trovata");
        return tratta;
    }
}

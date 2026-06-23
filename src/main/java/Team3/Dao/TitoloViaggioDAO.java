package Team3.Dao;

import Team3.entities.TitoloViaggio;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TitoloViaggioDAO {
    private final EntityManager entityManager;

    public TitoloViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public TitoloViaggio save(TitoloViaggio newTitoloViaggio) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newTitoloViaggio);
            transaction.commit();
        } catch (Exception ex) {
            throw new SaveException("Impossibile aggiungere un nuovo viaggio: " + ex.getMessage());
        }
        return newTitoloViaggio;
    }

    // SAVE BY ID
    public TitoloViaggio findById(String id) {
        TitoloViaggio viaggioTrovato = this.entityManager.find(TitoloViaggio.class, UUID.fromString(id));
        if (viaggioTrovato == null)
            throw new NotFoundException("Impossibile trovare il titolo di viaggio con id " + id);
        System.out.println("Il titolo di viaggio con id: " + id + " é stato trovato");
        return viaggioTrovato;
    }
}

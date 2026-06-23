package Team3.Dao;

import Team3.entities.TitoloViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TitoloViaggioDAO {
    private final EntityManager entityManager;

    public TitoloViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(TitoloViaggio newTitoloViaggio) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newTitoloViaggio);
            transaction.commit();
        } catch (Exception ex) {
            throw new Exception("Impossibile aggiungere un nuovo viaggio: " + ex.getMessage(), ex);
        }
    }

    // SAVE BY ID
    public TitoloViaggio findById(String id) {
        TitoloViaggio viaggioTrovato = this.entityManager.find(TitoloViaggio.class, UUID.fromString(id));
        if (viaggioTrovato == null) throw new NotFoundExceptions(id);
        return viaggioTrovato;
    }
}

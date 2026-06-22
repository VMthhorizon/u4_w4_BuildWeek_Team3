package Team3.Dao;

import Team3.entities.TitoloViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TitoloViaggioDAO {
    private final EntityManager entityManager;

    public TitoloViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
}

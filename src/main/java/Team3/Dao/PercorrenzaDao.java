package Team3.Dao;

import Team3.entities.Percorrenza;
import Team3.entities.TitoloViaggio;
import Team3.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PercorrenzaDao {
    private final EntityManager entityManager;

    public PercorrenzaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(Percorrenza newPercorrenza) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPercorrenza);
            transaction.commit();
        } catch (Exception ex) {
            throw new Exception("Impossibile aggiungere una nuova Percorrenza: " + ex.getMessage(), ex);
        }
    }

    //FIND BY ID
    public Percorrenza findById(String id) {
        Percorrenza percorrenzaTrovata = this.entityManager.find(Percorrenza.class, UUID.fromString(id));
        if (percorrenzaTrovata == null) throw new NotFoundException("Impossibile trovare la percorrenza con id " + id);
        return percorrenzaTrovata;
    }
}

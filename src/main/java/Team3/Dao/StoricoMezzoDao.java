package Team3.Dao;

import Team3.entities.StoricoMezzo;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class StoricoMezzoDao {

    private final EntityManager em;

    public StoricoMezzoDao(EntityManager em) {
        this.em = em;
    }

    public StoricoMezzo save(StoricoMezzo storico) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(storico);
            t.commit();
            System.out.println("Lo storico con id " + storico.getIdStorico() + " é stataosalvato");
        } catch (SaveException ex) {
            System.out.println("Lo storico: " + storico + " non é stata salvato");
        }
        return storico;
    }

    public StoricoMezzo findById(String id) {
        StoricoMezzo fromDb = em.find(StoricoMezzo.class, UUID.fromString(id));
        System.out.println("La storico con id " + id + " non é stato trovato");
        if (fromDb == null) throw new NotFoundException("La storico con id " + id + " non é stato trovato");
        return fromDb;
    }
}

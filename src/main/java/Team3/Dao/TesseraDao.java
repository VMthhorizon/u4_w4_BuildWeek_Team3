package Team3.Dao;

import Team3.entities.Tessera;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TesseraDao {

    private final EntityManager em;

    public TesseraDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(tessera);
            t.commit();
            System.out.println("La tessera con id " + tessera.getId() + " é stata salvata");
        } catch (SaveException ex) {
            System.out.println("La tessera: " + tessera + " non é stata salvata");
        }
    }

    public Tessera findById(String id) {
        Tessera fromDb = em.find(Tessera.class, UUID.fromString(id));
        System.out.println("La tessera con id " + id + " non é stata trovata");
        if (fromDb == null) throw new NotFoundException("La tessera con id " + id + " non é stata trovata");
        return fromDb;
    }
}

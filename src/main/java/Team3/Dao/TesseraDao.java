package Team3.Dao;

import Team3.entities.StoricoMezzo;
import Team3.entities.Tessera;
import Team3.entities.Utente;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TesseraDao {

    private final EntityManager em;

    public TesseraDao(EntityManager em) {
        this.em = em;
    }

    public Tessera save(Tessera tessera) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(tessera);
            t.commit();
            System.out.println("La tessera con id " + tessera.getId() + " é stata salvata");
        } catch (SaveException ex) {
            System.out.println("La tessera: " + tessera + " non é stata salvata");
        }
        return tessera;
    }

    public Tessera findById(String id) {
        Tessera fromDb = em.find(Tessera.class, UUID.fromString(id));
        if (fromDb == null) throw new NotFoundException("La tessera con id " + id + " non é stata trovata");
        return fromDb;
    }

    public Tessera findByUserId(String userId) {
        return em.createQuery("SELECT a FROM Tessera a WHERE a.utente.id = :id", Tessera.class)
                .setParameter("id", UUID.fromString(userId))
                .getSingleResult();
    }

    public Tessera setRinnovoTessera(String id, LocalDate data) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        Tessera tesseraFromDb = em.find(Tessera.class, UUID.fromString(id));

        tesseraFromDb.setDataEmissione(data);
        tesseraFromDb.setDataScadenza(data.plusYears(1));

        t.commit();
        return tesseraFromDb;
    }

    public List<Tessera> findAll() {
        return em.createQuery("SELECT t FROM Tessera t", Tessera.class)
                .getResultList();
    }

    public long count() {
        return em.createQuery("SELECT COUNT(t) FROM Tessera t", Long.class)
                .getSingleResult();
    }
}

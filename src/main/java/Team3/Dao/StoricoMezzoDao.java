package Team3.Dao;

import Team3.entities.StoricoMezzo;
import Team3.entities.Tessera;
import Team3.enums.StatoMezzo;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
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

    public List<StoricoMezzo> findPeriodiServizio(UUID idMezzo) {
        List<StoricoMezzo> result = em.createQuery(
                        "SELECT s FROM StoricoMezzo s WHERE s.mezzoDiTrasporto.id_mezzo = :idMezzo AND s.stato = " +
                                ":statoServizio ORDER BY s.dataInizio DESC",
                        StoricoMezzo.class)
                .setParameter("idMezzo", idMezzo)
                .setParameter("statoServizio", StatoMezzo.SERVIZIO)
                .getResultList();
        if (result.isEmpty()) throw new NotFoundException("Non ci sono storici di Servizio per il mezzo: " + idMezzo);
        return result;
    }

    public List<StoricoMezzo> findPeriodiManutenzione(UUID idMezzo) {
        List<StoricoMezzo> result = em.createQuery(
                        "SELECT s FROM StoricoMezzo s WHERE s.mezzoDiTrasporto.id_mezzo = :idMezzo AND s.stato = " +
                                ":statoManutenzione ORDER BY s.dataInizio DESC",
                        StoricoMezzo.class)
                .setParameter("idMezzo", idMezzo)
                .setParameter("statoManutenzione", StatoMezzo.MANUTENZIONE)
                .getResultList();
        if (result.isEmpty())
            throw new NotFoundException("Non ci sono storici di Manutenzione per il mezzo: " + idMezzo);
        return result;
    }

    public List<StoricoMezzo> findAll() {
        List<StoricoMezzo> result = em.createQuery("SELECT t FROM StoricoMezzo t", StoricoMezzo.class)
                .getResultList();
        if (result.isEmpty()) throw new NotFoundException("Non ci sono Storici mezzo nel Database!");
        return result;
    }

    public long count() {
        long result = em.createQuery("SELECT COUNT(t) FROM StoricoMezzo t", Long.class)
                .getSingleResult();
        if (result == 0) throw new NotFoundException("Non ci sono storici mezzi per il conteggio");
        return result;
    }
}

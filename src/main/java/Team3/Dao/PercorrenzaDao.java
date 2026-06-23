package Team3.Dao;

import Team3.entities.MezzoDiTrasporto;
import Team3.entities.Percorrenza;
import Team3.entities.StoricoMezzo;
import Team3.entities.TitoloViaggio;
import Team3.enums.StatoMezzo;
import Team3.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class PercorrenzaDao {
    private final EntityManager entityManager;

    public PercorrenzaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public Percorrenza save(Percorrenza newPercorrenza) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPercorrenza);
            transaction.commit();
            System.out.println("La percorrenza " + newPercorrenza + " é stata salvata");
        } catch (Exception ex) {
            throw new NotFoundException("Impossibile aggiungere una nuova Percorrenza: " + ex.getMessage());
        }
        return newPercorrenza;
    }

    // FIND BY ID
    public Percorrenza findById(String id) {
        Percorrenza percorrenzaTrovata = this.entityManager.find(Percorrenza.class, UUID.fromString(id));
        if (percorrenzaTrovata == null) throw new NotFoundException("Impossibile trovare la percorrenza con id " + id);
        System.out.println("La percorrenza con id: " + id + " é stata trovata");
        return percorrenzaTrovata;
    }

    // NUMERO CORSE
    public Long countNumeroCorse(UUID idMezzo, UUID idTratta) {
        return entityManager.createQuery("SELECT COUNT(p) FROM Percorrenza p WHERE p.mezzoDiTrasporto.id_mezzo = :idMezzo AND p.tratta.idTratta = :idTratta", Long.class)
                .setParameter("idMezzo", idMezzo)
                .setParameter("idTratta", idTratta)
                .getSingleResult();
    }

    // TEMPO MEDIO EFFETTIVO PERCORRENZA
    public Double AverageTempoPercorenza(UUID idMezzo, UUID idTratta) {
        return entityManager.createQuery("SELECT AVG(p.tempoEffettivo) FROM Percorrenza p WHERE p.mezzoDiTrasporto.id_mezzo = :idMezzo AND p.tratta.idTratta = :idTratta", Double.class)
                .setParameter("idMezzo", idMezzo)
                .setParameter("idTratta", idTratta)
                .getSingleResult();
    }
}

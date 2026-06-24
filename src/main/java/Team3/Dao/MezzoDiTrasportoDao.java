package Team3.Dao;

import Team3.entities.MezzoDiTrasporto;
import Team3.entities.Tessera;
import Team3.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.UUID;

public class MezzoDiTrasportoDao {

    private final EntityManager em;

    public MezzoDiTrasportoDao(EntityManager em) {
        this.em = em;
    }

    public MezzoDiTrasporto save(MezzoDiTrasporto mezzoDiTrasporto) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(mezzoDiTrasporto);
            t.commit();

            System.out.println(mezzoDiTrasporto + " é stato salvato");
        } catch (NotFoundException ex) {
            System.out.println("Il mezzo di trasporto " + mezzoDiTrasporto + " non é stato trovato");
        }
        return mezzoDiTrasporto;
    }

    public MezzoDiTrasporto findById(String id) {
        MezzoDiTrasporto mezzoFromDb = em.find(MezzoDiTrasporto.class, UUID.fromString(id));
        if (mezzoFromDb == null)
            throw new NotFoundException("Mezzo di trasporto con id: " + id + " non é stato trovato");
        System.out.println("Il mezzo con id: " + id + " é stato trovato");
        return mezzoFromDb;

    }

    public Long countTratteByMezzo(String idMezzo) {

        return em.createQuery("SELECT COUNT(DISTINCT p.tratta.idTratta) " + "FROM Percorrenza p " + "WHERE p.mezzoDiTrasporto.id_mezzo = :mezzoId", Long.class)
                .setParameter("mezzoId", UUID.fromString(idMezzo))
                .getSingleResult();
    }

    public List<MezzoDiTrasporto> findAll() {
        return em.createQuery("SELECT t FROM MezzoDiTrasporto t", MezzoDiTrasporto.class)
                .getResultList();
    }

    public long count() {
        return em.createQuery("SELECT COUNT(t) FROM MezzoDiTrasporto t", Long.class)
                .getSingleResult();
    }
}
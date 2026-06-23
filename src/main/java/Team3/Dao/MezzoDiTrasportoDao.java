package Team3.Dao;

import Team3.entities.MezzoDiTrasporto;
import Team3.exceptions.MezzoNotSaved;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class MezzoDiTrasportoDao {

    private final EntityManager em;

    public MezzoDiTrasportoDao(EntityManager em) {
        this.em = em;
    }

    public void saveMezzo(MezzoDiTrasporto mezzoDiTrasporto) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(mezzoDiTrasporto);
            t.commit();

            System.out.println(mezzoDiTrasporto + " é stato salvato");
        } catch (MezzoNotSaved ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MezzoDiTrasporto findById(UUID id) {
        return em.find(MezzoDiTrasporto.class, id);
    }
}

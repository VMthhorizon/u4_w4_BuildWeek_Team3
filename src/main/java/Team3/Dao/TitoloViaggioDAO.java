package Team3.Dao;

import Team3.entities.*;
import Team3.exceptions.NotFoundException;
import Team3.exceptions.SaveException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TitoloViaggioDAO {
    private final EntityManager entityManager;

    public TitoloViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public TitoloViaggio save(TitoloViaggio newTitoloViaggio) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newTitoloViaggio);
            transaction.commit();
        } catch (Exception ex) {
            throw new SaveException("Impossibile aggiungere un nuovo viaggio: " + ex.getMessage());
        }
        return newTitoloViaggio;
    }

    // SAVE BY ID
    public TitoloViaggio findById(String id) {
        TitoloViaggio viaggioTrovato = this.entityManager.find(TitoloViaggio.class, UUID.fromString(id));
        if (viaggioTrovato == null)
            throw new NotFoundException("Impossibile trovare il titolo di viaggio con id " + id);
        System.out.println("Il titolo di viaggio con id: " + id + " é stato trovato");
        return viaggioTrovato;
    }

    // QUERIES

    // ABBONAMENTO tramite TesseraID  UTENTE e CONTROLLORE

    public List<Abbonamento> abbonamentoByIdTessera(String id) {
        List<Abbonamento> result = entityManager.createQuery(
                        "SELECT a FROM Abbonamento a WHERE a.tessera.id = :idTessera", Abbonamento.class)
                .setParameter("idTessera", UUID.fromString(id))
                .getResultList();
        if (result.isEmpty()) throw new NotFoundException("Nessun abbonamento trovato con l'Id tessera: " + id);
        return result;
    }

    // COUNT BIGLIETTO BY DATE  SOLO CONTROLLORE
    public Long totaleBigliettiByDate(LocalDate dataInizio, LocalDate dataFine) {
        Long result = entityManager.createQuery(
                        "SELECT COUNT (b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine",
                        Long.class)
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getSingleResult();
        if (result == 0) throw new NotFoundException("Non ci sono biglietti in queste date");
        return result;
    }

    // COUNT ABBONAMENTO BY DATE  SOLO CONTROLLORE
    public Long totaleAbbonamentiByDate(LocalDate dataInizio, LocalDate dataFine) {
        Long result = entityManager.createQuery(
                        "SELECT COUNT (b) FROM Abbonamento b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine",
                        Long.class)
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getSingleResult();
        if (result == 0) throw new NotFoundException("Non ci sono abbonamenti in queste date");
        return result;
    }

    //COUNT BIGLIETTO by PUNTO EMISSIONE e DATE SOLO CONTROLLORE
    public Long totaleBigliettiByPuntoEmissioneDate(String emissioneId, LocalDate dataInizio,
                                                    LocalDate dataFine) {
        Long result = entityManager.createQuery(
                        "SELECT COUNT(b) FROM Biglietto b WHERE b.puntoDiEmissione.id = :emissioneId AND (b" +
                                ".dataEmissione BETWEEN :dataInizio AND :dataFine)", Long.class)
                .setParameter("emissioneId", UUID.fromString(emissioneId))
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getSingleResult();
        if (result == 0) throw new NotFoundException("Non ci sono biglietti!");
        return result;
    }

    //COUNT ABBONAMENTI by PUNTO EMISSIONE e DATE  SOLO CONTROLLORE
    public Long totaleAbbonamentiByPuntoEmissioneDate(String emissioneId, LocalDate dataInizio,
                                                      LocalDate dataFine) {
        Long result = entityManager.createQuery(
                        "SELECT COUNT(b) FROM Abbonamento b WHERE b.puntoDiEmissione.id = :emissioneId AND (b" +
                                ".dataEmissione BETWEEN :dataInizio AND :dataFine)", Long.class)
                .setParameter("emissioneId", UUID.fromString(emissioneId))
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getSingleResult();
        if (result == 0) throw new NotFoundException("Non ci sono abbonamenti!");
        return result;
    }

    //COUNT BIGLIETTI OBLITERATI by MEZZO   SOLO CONTROLLORE
    public Long totaleBigliettiVidimatiByMezzo(String idMezzo) {
        return entityManager.createQuery(
                        "SELECT COUNT(a) FROM Biglietto a WHERE a.isValido = false AND a.mezzoDiTrasporto.id_mezzo = " +
                                ":idMezzo",
                        Long.class)
                .setParameter("idMezzo", UUID.fromString(idMezzo))
                .getSingleResult();
    }

    //COUNT BIGLIETTI OBLITERATI by DATE    SOLO CONTROLLORE
    public Long totaleBigliettiVidimatiByDate(LocalDate inizio, LocalDate fine) {
        return entityManager.createQuery(
                        "SELECT COUNT(a) FROM Biglietto a WHERE a.isValido = false AND a.dataDiUtilizzo BETWEEN " +
                                ":inizio AND :fine",
                        Long.class)
                .setParameter("inizio", inizio)
                .setParameter("fine", fine)
                .getSingleResult();
    }

    public List<TitoloViaggio> findAll() {
        return entityManager.createQuery("SELECT t FROM TitoloViaggio t", TitoloViaggio.class)
                .getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(t) FROM TitoloViaggio t", Long.class)
                .getSingleResult();
    }
}

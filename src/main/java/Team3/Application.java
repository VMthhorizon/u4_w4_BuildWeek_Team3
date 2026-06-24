package Team3;

import Team3.Dao.*;
import Team3.classes.CreateUsers;
import Team3.entities.*;
import Team3.enums.StatoDistributore;
import Team3.enums.StatoMezzo;
import Team3.enums.TipoAbbonamento;
import Team3.enums.TipoManutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4buildweekpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        MezzoDiTrasportoDao mezzoDao = new MezzoDiTrasportoDao(em);
        PercorrenzaDao percorrenzaDao = new PercorrenzaDao(em);
        PuntoDiEmissioneDao puntoEmissioneDao = new PuntoDiEmissioneDao(em);
        StoricoMezzoDao storicoMezzoDao = new StoricoMezzoDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        TitoloViaggioDAO titoloViaggioDao = new TitoloViaggioDAO(em);
        TrattaDao trattaDao = new TrattaDao(em);
        UtenteDao utenteDao = new UtenteDao(em);

        Utente u1 = new Utente("aldo", "baglio");
        Utente u2 = new Utente("giovanni", "storti");
        Utente u3 = new Utente("giacomo", "poretti");
        Utente u4 = new Utente("antonio", "albanese");
        Utente u5 = new Utente("claudio", "bisio");
        Utente u6 = new Utente("leonardo", "dicaprio");
        Utente u7 = new Utente("brad", "pitt");
        Utente u8 = new Utente("morgan", "freeman");
        Utente u9 = new Utente("tom", "hanks");
        Utente u10 = new Utente("robert", "deniro");

        Utente user1 = utenteDao.save(u1);
        Utente user2 = utenteDao.save(u2);
        Utente user3 = utenteDao.save(u3);
        Utente user4 = utenteDao.save(u4);
        Utente user5 = utenteDao.save(u5);
        Utente user6 = utenteDao.save(u6);
        Utente user7 = utenteDao.save(u7);
        Utente user8 = utenteDao.save(u8);
        Utente user9 = utenteDao.save(u9);
        Utente user10 = utenteDao.save(u10);

        Utente u1FromDb = utenteDao.findById(user1.getId()
                .toString());
        Utente u2FromDb = utenteDao.findById(user2.getId()
                .toString());
        Utente u3FromDb = utenteDao.findById(user3.getId()
                .toString());
        Utente u4FromDb = utenteDao.findById(user4.getId()
                .toString());
        Utente u5FromDb = utenteDao.findById(user5.getId()
                .toString());
        Utente u6FromDb = utenteDao.findById(user6.getId()
                .toString());
        Utente u7FromDb = utenteDao.findById(user7.getId()
                .toString());
        Utente u8FromDb = utenteDao.findById(user8.getId()
                .toString());
        Utente u9FromDb = utenteDao.findById(user9.getId()
                .toString());
        Utente u10FromDb = utenteDao.findById(user10.getId()
                .toString());

        CreateUsers user = new CreateUsers();
        List<Utente> listUtente = user.createUtente(utenteDao);

        // OGGETTI TESSERA ANCORA NON MANAGED

        Tessera tessera1 = new Tessera(LocalDate.of(2026, 4, 20), u1FromDb);
        Tessera tessera2 = new Tessera(LocalDate.of(2024, 6, 18), u2FromDb);
        Tessera tessera3 = new Tessera(LocalDate.of(2025, 5, 3), u3FromDb);
        Tessera tessera4 = new Tessera(LocalDate.of(2025, 8, 19), u4FromDb);
        Tessera tessera5 = new Tessera(LocalDate.of(2025, 11, 12), u5FromDb);
        Tessera tessera6 = new Tessera(LocalDate.of(2026, 1, 5), u6FromDb);
        Tessera tessera7 = new Tessera(LocalDate.of(2026, 3, 30), u7FromDb);
        Tessera tessera8 = new Tessera(LocalDate.of(2026, 5, 14), u8FromDb);
        Tessera tessera9 = new Tessera(LocalDate.of(2026, 6, 22), u9FromDb);
        Tessera tessera10 = new Tessera(LocalDate.of(2025, 2, 15), u10FromDb);

        // PERSISTENZA TESSERE

        Tessera t1 = tesseraDao.save(tessera1);
        Tessera t2 = tesseraDao.save(tessera2);
        Tessera t3 = tesseraDao.save(tessera3);
        Tessera t4 = tesseraDao.save(tessera4);
        Tessera t5 = tesseraDao.save(tessera5);
        Tessera t6 = tesseraDao.save(tessera6);
        Tessera t7 = tesseraDao.save(tessera7);
        Tessera t8 = tesseraDao.save(tessera8);
        Tessera t9 = tesseraDao.save(tessera9);
        Tessera t10 = tesseraDao.save(tessera10);


        // ISTANZIARE TESSERE DAL DB NELLE VARIABILI


        Tessera tessera1FromDb = tesseraDao.findById(t1.getId()
                .toString());
        Tessera tessera2FromDb = tesseraDao.findById(t2.getId()
                .toString());
        Tessera tessera3FromDb = tesseraDao.findById(t3.getId()
                .toString());
        Tessera tessera4FromDb = tesseraDao.findById(t4.getId()
                .toString());
        Tessera tessera5FromDb = tesseraDao.findById(t5.getId()
                .toString());
        Tessera tessera6FromDb = tesseraDao.findById(t6.getId()
                .toString());
        Tessera tessera7FromDb = tesseraDao.findById(t7.getId()
                .toString());
        Tessera tessera8FromDb = tesseraDao.findById(t8.getId()
                .toString());
        Tessera tessera9FromDb = tesseraDao.findById(t9.getId()
                .toString());
        Tessera tessera10FromDb = tesseraDao.findById(t10.getId()
                .toString());

        // OGGETTI PUNTIdiEMISSIONE NON ANCORA MANAGED

        Distributore distr1 = new Distributore("TicketNapoli_Centrale", StatoDistributore.ATTIVO);
        Distributore distr2 = new Distributore("TicketMilano_Centrale", StatoDistributore.FUORI_SERVIZIO);
        Distributore distr3 = new Distributore("MetroRoma_Termini", StatoDistributore.ATTIVO);
        Distributore distr4 = new Distributore("CinemaFellini_Kiosk", StatoDistributore.FUORI_SERVIZIO);
        Distributore distr5 = new Distributore("Trenitalia_SelfService", StatoDistributore.ATTIVO);
        Rivenditore rivend1 = new Rivenditore("Tabaccheria dei Re", "via Maurizio Piscicelli 42", LocalTime.of(8, 0),
                LocalTime.of(19, 0));
        Rivenditore rivend2 = new Rivenditore("Edicola Centrale", "Piazza Garibaldi 15", LocalTime.of(6, 30),
                LocalTime.of(20, 0));

        Rivenditore rivend3 = new Rivenditore("Bar dello Sport", "Corso Vittorio Emanuele 102", LocalTime.of(6, 0),
                LocalTime.of(21, 0));

        Rivenditore rivend4 = new Rivenditore("Tabacchi e Servizi", "Via Roma 74", LocalTime.of(7, 45),
                LocalTime.of(19, 30));

        Rivenditore rivend5 = new Rivenditore("Cafè della Stazione", "Viale dei Mille 9", LocalTime.of(8, 15),
                LocalTime.of(20, 30));


        // PERSISTENZA DITRIBUTORI e RIVENDITORI

        PuntoDiEmissione pe1 = puntoEmissioneDao.save(distr1);
        PuntoDiEmissione pe2 = puntoEmissioneDao.save(distr2);
        PuntoDiEmissione pe3 = puntoEmissioneDao.save(distr3);
        PuntoDiEmissione pe4 = puntoEmissioneDao.save(distr4);
        PuntoDiEmissione pe5 = puntoEmissioneDao.save(distr5);
        PuntoDiEmissione pe6 = puntoEmissioneDao.save(rivend1);
        PuntoDiEmissione pe7 = puntoEmissioneDao.save(rivend2);
        PuntoDiEmissione pe8 = puntoEmissioneDao.save(rivend3);
        PuntoDiEmissione pe9 = puntoEmissioneDao.save(rivend4);
        PuntoDiEmissione pe10 = puntoEmissioneDao.save(rivend5);


        // ISTANZIARE DISTRIBUTORI e RIVENDITORI DAL DB NELLE VARIABILI

        PuntoDiEmissione dist1FromDb = puntoEmissioneDao.findById(pe1.getId()
                .toString());
        PuntoDiEmissione dist2FromDb = puntoEmissioneDao.findById(pe2.getId()
                .toString());
        PuntoDiEmissione dist3FromDb = puntoEmissioneDao.findById(pe3.getId()
                .toString());
        PuntoDiEmissione dist4FromDb = puntoEmissioneDao.findById(pe4.getId()
                .toString());
        PuntoDiEmissione dist5FromDb = puntoEmissioneDao.findById(pe5.getId()
                .toString());
        PuntoDiEmissione riven1FromDb = puntoEmissioneDao.findById(pe6.getId()
                .toString());
        PuntoDiEmissione riven2FromDb = puntoEmissioneDao.findById(pe7.getId()
                .toString());
        PuntoDiEmissione riven3FromDb = puntoEmissioneDao.findById(pe8.getId()
                .toString());
        PuntoDiEmissione riven4FromDb = puntoEmissioneDao.findById(pe9.getId()
                .toString());
        PuntoDiEmissione riven5FromDb = puntoEmissioneDao.findById(pe10.getId()
                .toString());

        // OGGETTI MEZZI DI TRASPORTO NON ANCORA MANAGED

        Tram tram1 = new Tram(StatoMezzo.MANUTENZIONE, 80);
        Tram tram2 = new Tram(StatoMezzo.SERVIZIO, 120);
        Tram tram3 = new Tram(StatoMezzo.MANUTENZIONE, 90);
        Tram tram4 = new Tram(StatoMezzo.SERVIZIO, 150);
        Tram tram5 = new Tram(StatoMezzo.MANUTENZIONE, 110);
        Autobus bus1 = new Autobus(StatoMezzo.MANUTENZIONE, 200);
        Autobus bus2 = new Autobus(StatoMezzo.SERVIZIO, 150);
        Autobus bus3 = new Autobus(StatoMezzo.MANUTENZIONE, 180);
        Autobus bus4 = new Autobus(StatoMezzo.SERVIZIO, 220);
        Autobus bus5 = new Autobus(StatoMezzo.MANUTENZIONE, 250);

        // PERSISTENZA di TRAM e BUS

        MezzoDiTrasporto m1 = mezzoDao.save(tram1);
        MezzoDiTrasporto m2 = mezzoDao.save(tram2);
        MezzoDiTrasporto m3 = mezzoDao.save(tram3);
        MezzoDiTrasporto m4 = mezzoDao.save(tram4);
        MezzoDiTrasporto m5 = mezzoDao.save(tram5);
        MezzoDiTrasporto m6 = mezzoDao.save(bus1);
        MezzoDiTrasporto m7 = mezzoDao.save(bus2);
        MezzoDiTrasporto m8 = mezzoDao.save(bus3);
        MezzoDiTrasporto m9 = mezzoDao.save(bus4);
        MezzoDiTrasporto m10 = mezzoDao.save(bus5);


        // ISTANZIARE TRAM e BUS DAL DB NELLE VARIABILI


        MezzoDiTrasporto mezzoDiTrasporto1FromDb = mezzoDao.findById(m1.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto2FromDb = mezzoDao.findById(m2.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto3FromDb = mezzoDao.findById(m3.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto4FromDb = mezzoDao.findById(m4.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto5FromDb = mezzoDao.findById(m5.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto6FromDb = mezzoDao.findById(m6.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto7FromDb = mezzoDao.findById(m7.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto8FromDb = mezzoDao.findById(m8.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto9FromDb = mezzoDao.findById(m9.getId_mezzo()
                .toString());
        MezzoDiTrasporto mezzoDiTrasporto10FromDb = mezzoDao.findById(m10.getId_mezzo()
                .toString());

        // OGGETTI ABBONAMENTO e BIGLIETTO NON ANCORA MANAGED
//
        Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 5, 10), dist1FromDb, true, null,
                mezzoDiTrasporto1FromDb);
        Biglietto biglietto2 = new Biglietto(LocalDate.of(2026, 1, 12), riven1FromDb, false, LocalDate.of(2026, 3, 1),
                mezzoDiTrasporto2FromDb);
        Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 8), dist2FromDb, false, LocalDate.of(2026, 4, 13),
                mezzoDiTrasporto3FromDb);
        Biglietto biglietto4 = new Biglietto(LocalDate.of(2026, 4, 2), riven2FromDb, true, null,
                mezzoDiTrasporto4FromDb);
        Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 3, 21), riven3FromDb, true, null,
                mezzoDiTrasporto5FromDb);
        Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 6, 3), dist3FromDb, TipoAbbonamento.SETTIMANALE,
                tessera1FromDb, LocalDate.of(2026, 6, 15)); // Questo sarà SCADUTA
        Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2026, 5, 20), dist4FromDb, TipoAbbonamento.MENSILE,
                tessera2FromDb, LocalDate.of(2026, 6, 3)); // Questo sarà SCADUTA
        Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2026, 6, 23), riven4FromDb, TipoAbbonamento
                .SETTIMANALE,
                tessera3FromDb, LocalDate.of(2026, 7, 12)); // VALIDO non scaduta
        Abbonamento abbonamento4 = new Abbonamento(LocalDate.of(2026, 6, 20), dist5FromDb, TipoAbbonamento.MENSILE,
                tessera4FromDb, LocalDate.of(2026, 8, 20)); //VALIDO non scaduto
        Abbonamento abbonamento5 = new Abbonamento(LocalDate.of(2026, 3, 15), riven5FromDb, TipoAbbonamento.MENSILE,
                tessera5FromDb, LocalDate.of(2026, 7, 22)); // SCADUTO non valido

        // PERSTISTENZA ABBONAMENTO e BIGLIETTO


        TitoloViaggio tv1 = titoloViaggioDao.save(biglietto1);
        TitoloViaggio tv2 = titoloViaggioDao.save(biglietto2);
        TitoloViaggio tv3 = titoloViaggioDao.save(biglietto3);
        TitoloViaggio tv4 = titoloViaggioDao.save(biglietto4);
        TitoloViaggio tv5 = titoloViaggioDao.save(biglietto5);
        TitoloViaggio tv6 = titoloViaggioDao.save(abbonamento1);
        TitoloViaggio tv7 = titoloViaggioDao.save(abbonamento2);
        TitoloViaggio tv8 = titoloViaggioDao.save(abbonamento3);
        TitoloViaggio tv9 = titoloViaggioDao.save(abbonamento4);
        TitoloViaggio tv10 = titoloViaggioDao.save(abbonamento5);


        // ISTANZIARE BIGLIETTI e ABBONAMENTI DAL DB


        TitoloViaggio biglietto1FromDb = titoloViaggioDao.findById(tv1.getId()
                .toString());
        TitoloViaggio biglietto2FromDb = titoloViaggioDao.findById(tv2.getId()
                .toString());
        TitoloViaggio biglietto3FromDb = titoloViaggioDao.findById(tv3.getId()
                .toString());
        TitoloViaggio biglietto4FromDb = titoloViaggioDao.findById(tv4.getId()
                .toString());
        TitoloViaggio biglietto5FromDb = titoloViaggioDao.findById(tv5.getId()
                .toString());
        TitoloViaggio abbonamento1FromDb = titoloViaggioDao.findById(tv6.getId()
                .toString());
        TitoloViaggio abbonamento2FromDb = titoloViaggioDao.findById(tv7.getId()
                .toString());
        TitoloViaggio abbonamento3FromDb = titoloViaggioDao.findById(tv8.getId()
                .toString());
        TitoloViaggio abbonamento4FromDb = titoloViaggioDao.findById(tv9.getId()
                .toString());
        TitoloViaggio abbonamento5FromDb = titoloViaggioDao.findById(tv10.getId()
                .toString());

        // OGGETTI TRATTA NON MANAGED

        Tratta tratta1 = new Tratta("Milano Centrale", "Rho Fiera", 35);
        Tratta tratta2 = new Tratta("Trastevere", "Roma Termini", 20);
        Tratta tratta3 = new Tratta("Torino Porta Nuova", "Lingotto", 15);
        Tratta tratta4 = new Tratta("Bologna Centrale", "Casalecchio", 25);
        Tratta tratta5 = new Tratta("Firenze SMN", "Campo di Marte", 12);
        Tratta tratta6 = new Tratta("Venezia Mestre", "Piazzale Roma", 15);
        Tratta tratta7 = new Tratta("Genova Brignole", "Genova Voltri", 30);
        Tratta tratta8 = new Tratta("Palermo Centrale", "Mondello", 45);
        Tratta tratta9 = new Tratta("Bari Centrale", "Torre a Mare", 22);
        Tratta tratta10 = new Tratta("Cagliari Piazza Matteotti", "Poetto", 18);

        // PERSISTENZA OGGETTI TRATTA

        Tratta tr1 = trattaDao.save(tratta1);
        Tratta tr2 = trattaDao.save(tratta2);
        Tratta tr3 = trattaDao.save(tratta3);
        Tratta tr4 = trattaDao.save(tratta4);
        Tratta tr5 = trattaDao.save(tratta5);
        Tratta tr6 = trattaDao.save(tratta6);
        Tratta tr7 = trattaDao.save(tratta7);
        Tratta tr8 = trattaDao.save(tratta8);
        Tratta tr9 = trattaDao.save(tratta9);
        Tratta tr10 = trattaDao.save(tratta10);


        // ISTANZIARE TRATTE DAL DB


        Tratta tratta1FromDb = trattaDao.findById(tr1.getIdTratta()
                .toString());
        Tratta tratta2FromDb = trattaDao.findById(tr2.getIdTratta()
                .toString());
        Tratta tratta3FromDb = trattaDao.findById(tr3.getIdTratta()
                .toString());
        Tratta tratta4FromDb = trattaDao.findById(tr4.getIdTratta()
                .toString());
        Tratta tratta5FromDb = trattaDao.findById(tr5.getIdTratta()
                .toString());
        Tratta tratta6FromDb = trattaDao.findById(tr6.getIdTratta()
                .toString());
        Tratta tratta7FromDb = trattaDao.findById(tr7.getIdTratta()
                .toString());
        Tratta tratta8FromDb = trattaDao.findById(tr8.getIdTratta()
                .toString());
        Tratta tratta9FromDb = trattaDao.findById(tr9.getIdTratta()
                .toString());
        Tratta tratta10FromDb = trattaDao.findById(tr10.getIdTratta()
                .toString());

        // OGGETTI STORICO MEZZI NON MANAGED

        StoricoMezzo storico1 = new StoricoMezzo(mezzoDiTrasporto1FromDb, LocalDate.of(2026, 6, 26), null, null);
        StoricoMezzo storico2 = new StoricoMezzo(mezzoDiTrasporto2FromDb, LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 11),
                TipoManutenzione.CARBURANTE);
        StoricoMezzo storico3 = new StoricoMezzo(mezzoDiTrasporto3FromDb, LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 2),
                TipoManutenzione.FRENI);
        StoricoMezzo storico4 = new StoricoMezzo(mezzoDiTrasporto4FromDb, LocalDate.of(2026, 6, 12),
                LocalDate.of(2026, 6, 13),
                TipoManutenzione.GOMME);
        StoricoMezzo storico5 = new StoricoMezzo(mezzoDiTrasporto5FromDb, LocalDate.of(2026, 6, 25), null, null);
        StoricoMezzo storico6 = new StoricoMezzo(mezzoDiTrasporto6FromDb, LocalDate.of(2026, 6, 26), null, null);
        StoricoMezzo storico7 = new StoricoMezzo(mezzoDiTrasporto7FromDb, LocalDate.of(2026, 5, 20),
                LocalDate.of(2026, 5, 21),
                TipoManutenzione.MOTORE);
        StoricoMezzo storico8 = new StoricoMezzo(mezzoDiTrasporto8FromDb, LocalDate.of(2026, 6, 5),
                LocalDate.of(2026, 6, 6),
                TipoManutenzione.FRENI);
        StoricoMezzo storico9 = new StoricoMezzo(mezzoDiTrasporto9FromDb, LocalDate.of(2026, 6, 25), null, null);
        StoricoMezzo storico10 = new StoricoMezzo(mezzoDiTrasporto10FromDb, LocalDate.of(2026, 6, 26), null, null);

        // PERSISTENZA OGGETTI STORICO MEZZI

        StoricoMezzo str1 = storicoMezzoDao.save(storico1);
        StoricoMezzo str2 = storicoMezzoDao.save(storico2);
        StoricoMezzo str3 = storicoMezzoDao.save(storico3);
        StoricoMezzo str4 = storicoMezzoDao.save(storico4);
        StoricoMezzo str5 = storicoMezzoDao.save(storico5);
        StoricoMezzo str6 = storicoMezzoDao.save(storico6);
        StoricoMezzo str7 = storicoMezzoDao.save(storico7);
        StoricoMezzo str8 = storicoMezzoDao.save(storico8);
        StoricoMezzo str9 = storicoMezzoDao.save(storico9);
        StoricoMezzo str10 = storicoMezzoDao.save(storico10);

        // ISTANZIARE STORICO MEZZO DAL DB

        StoricoMezzo storico1FromDb = storicoMezzoDao.findById(str1.getIdStorico()
                .toString());
        StoricoMezzo storico2FromDb = storicoMezzoDao.findById(str2.getIdStorico()
                .toString());
        StoricoMezzo storico3FromDb = storicoMezzoDao.findById(str3.getIdStorico()
                .toString());
        StoricoMezzo storico4FromDb = storicoMezzoDao.findById(str4.getIdStorico()
                .toString());
        StoricoMezzo storico5FromDb = storicoMezzoDao.findById(str5.getIdStorico()
                .toString());
        StoricoMezzo storico6FromDb = storicoMezzoDao.findById(str6.getIdStorico()
                .toString());
        StoricoMezzo storico7FromDb = storicoMezzoDao.findById(str7.getIdStorico()
                .toString());
        StoricoMezzo storico8FromDb = storicoMezzoDao.findById(str8.getIdStorico()
                .toString());
        StoricoMezzo storico9FromDb = storicoMezzoDao.findById(str9.getIdStorico()
                .toString());
        StoricoMezzo storico10FromDb = storicoMezzoDao.findById(str10.getIdStorico()
                .toString());

        // OGGETTI PERCORRENZA NON MANAGED

        Percorrenza percorrenza1 = new Percorrenza(tratta1FromDb, mezzoDiTrasporto1FromDb, 30,
                LocalDate.of(2026, 6, 22)); // IN ANTICIPO
        Percorrenza percorrenza2 = new Percorrenza(tratta2FromDb, mezzoDiTrasporto2FromDb, 20,
                LocalDate.of(2026, 6, 23)); // IN ORARIO
        Percorrenza percorrenza3 = new Percorrenza(tratta3FromDb, mezzoDiTrasporto3FromDb, 22,
                LocalDate.of(2026, 6, 24)); // IN RITARDO
        Percorrenza percorrenza4 = new Percorrenza(tratta4FromDb, mezzoDiTrasporto4FromDb, 21,
                LocalDate.of(2026, 6, 25)); // IN ANTICIPO
        Percorrenza percorrenza5 = new Percorrenza(tratta5FromDb, mezzoDiTrasporto5FromDb, 12,
                LocalDate.of(2026, 6, 26)); // IN ORARIO
        Percorrenza percorrenza6 = new Percorrenza(tratta6FromDb, mezzoDiTrasporto6FromDb, 19,
                LocalDate.of(2026, 6, 27)); // IN RITARDO
        Percorrenza percorrenza7 = new Percorrenza(tratta7FromDb, mezzoDiTrasporto7FromDb, 35,
                LocalDate.of(2026, 6, 28)); // IN RITARDO
        Percorrenza percorrenza8 = new Percorrenza(tratta8FromDb, mezzoDiTrasporto8FromDb, 45,
                LocalDate.of(2026, 6, 29)); // IN ORARIO
        Percorrenza percorrenza9 = new Percorrenza(tratta9FromDb, mezzoDiTrasporto9FromDb, 18,
                LocalDate.of(2026, 6, 30)); // IN ANTICIPO
        Percorrenza percorrenza10 = new Percorrenza(tratta10FromDb, mezzoDiTrasporto10FromDb, 25,
                LocalDate.of(2026, 5, 27)); // IN RITARDO

        // PERSISTERE OGGETTI PERCORRENZA

        Percorrenza per1 = percorrenzaDao.save(percorrenza1);
        Percorrenza per2 = percorrenzaDao.save(percorrenza2);
        Percorrenza per3 = percorrenzaDao.save(percorrenza3);
        Percorrenza per4 = percorrenzaDao.save(percorrenza4);
        Percorrenza per5 = percorrenzaDao.save(percorrenza5);
        Percorrenza per6 = percorrenzaDao.save(percorrenza6);
        Percorrenza per7 = percorrenzaDao.save(percorrenza7);
        Percorrenza per8 = percorrenzaDao.save(percorrenza8);
        Percorrenza per9 = percorrenzaDao.save(percorrenza9);
        Percorrenza per10 = percorrenzaDao.save(percorrenza10);

        // ISTANZIARE PERCORRENZE DAL DB

        Percorrenza percorrenza1FromDb = percorrenzaDao.findById(per1.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza2FromDb = percorrenzaDao.findById(per2.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza3FromDb = percorrenzaDao.findById(per3.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza4FromDb = percorrenzaDao.findById(per4.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza5FromDb = percorrenzaDao.findById(per5.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza6FromDb = percorrenzaDao.findById(per6.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza7FromDb = percorrenzaDao.findById(per7.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza8FromDb = percorrenzaDao.findById(per8.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza9FromDb = percorrenzaDao.findById(per9.getIdPercorrenza()
                .toString());
        Percorrenza percorrenza10FromDb = percorrenzaDao.findById(per10.getIdPercorrenza()
                .toString());


        // QUERIES

        // ABBONAMENTO tramite TesseraID  UTENTE e CONTROLLORE

//        System.out.println(titoloViaggioDao.abbonamentoByIdTessera(t1.getId()
//                .toString()));


        // COUNT BIGLIETTO BY DATE  SOLO CONTROLLORE

//        System.out.println(titoloViaggioDao.totaleBigliettiByDate(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 6,
//                22)));


        // COUNT ABBONAMENTO BY DATE  SOLO CONTROLLORE

//        System.out.println(
//                titoloViaggioDao.totaleAbbonamentiByDate(LocalDate.of(2026, 3, 1), LocalDate.of(2026, 5, 22)));


        //COUNT BIGLIETTO by PUNTO EMISSIONE e DATE SOLO CONTROLLORE

//        System.out.println(titoloViaggioDao.totaleBigliettiByPuntoEmissioneDate
//                (pe1.getId()
//                                .toString(),
//                        LocalDate.of(2026, 1, 1), LocalDate.of(2026, 6, 22)));


        //COUNT ABBONAMENTI by PUNTO EMISSIONE e DATE  SOLO CONTROLLORE

//        System.out.println(
//                titoloViaggioDao.totaleAbbonamentiByPuntoEmissioneDate(pe1.getId()
//                                .toString(),
//                        LocalDate.of(2026, 1, 1), LocalDate.of(2026, 6, 22)));


        //COUNT BIGLIETTI OBLITERATI by MEZZO   SOLO CONTROLLORE

//        System.out.println(titoloViaggioDao.totaleBigliettiVidimatiByMezzo(m1.getId_mezzo().toString()));


        //COUNT BIGLIETTI OBLITERATI by DATE    SOLO CONTROLLORE

//        System.out.println(
//                titoloViaggioDao.totaleBigliettiVidimatiByDate(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 6, 22)));


//        List<StoricoMezzo> periodiManutenzione = storicoMezzoDao.findPeriodiManutenzione(m1.getId_mezzo());
//
//        System.out.println("--- PERIODI DI MANUTENZIONE PER IL MEZZO " + m1.getId_mezzo() + " ---");
//        if (periodiManutenzione.isEmpty()) {
//            System.out.println("Nessun periodo di manutenzione registrato per questo mezzo.");
//        } else {
//            periodiManutenzione.forEach(System.out::println));
//        }

//        List<StoricoMezzo> periodiManutenzione = storicoMezzoDao.findPeriodiManutenzione(m1.getId_mezzo());
//
//        System.out.println("\n--- RISULTATO: PERIODI DI MANUTENZIONE PER IL MEZZO " + m1.getId_mezzo() + " ---");
//        if (periodiManutenzione.isEmpty()) {
//            System.out.println("Nessun periodo di manutenzione registrato per questo mezzo.");
//        } else {
//            periodiManutenzione.forEach(System.out::println);
//        }

        /*Long count = mezzoDao.CountTratteByMezzo(
                m1.getId_mezzo().toString()
        );

        System.out.println("tratte: " + count);*/

//        System.out.println("prova count mezzi percorrenza");
//        System.out.println(percorrenzaDao.countNumeroCorse(m1.getId_mezzo(), tr1.getIdTratta()));


        // SCANNER
        System.out.println("Login");
        int scelta;
        int sceltaUtente;
        do {
            System.out.println("""
                    1. Area Utente
                    2. Area Amministratore
                    0. Esci
                    """);

            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.println("Area Utente");

                    System.out.println("Inserisci i tuoi dati per registrarti come utente");
                    System.out.println("nome");
                    String nome = scanner.nextLine();
                    System.out.println("cognome");
                    String cognome = scanner.nextLine();

                    Utente utenteRegistrato = new Utente(nome, cognome);
                    utenteDao.save(utenteRegistrato);
                    Tessera tesseraUtenteRegistrato = new Tessera(LocalDate.now(), utenteRegistrato);
                    tesseraDao.save(tesseraUtenteRegistrato);
                    do {
                        System.out.println("""
                                1. Acquista biglietto
                                2. Acquista abbonamento mensile
                                3. Acquista abbonamento settimanale
                                4. Controlla validità tessera
                                5. I miei abbonamenti
                                6. Valida biglietto
                                0. Esci
                                """);
                        sceltaUtente = Integer.parseInt(scanner.nextLine());

                        switch (sceltaUtente) {
                            case 1:
                                TitoloViaggio titoloViaggio = new Biglietto(LocalDate.now(), pe1, false, null, m2);
                                titoloViaggioDao.save(titoloViaggio);
                                System.out.println("Biglietto acquistato correttamente");
                                break;
                            case 2:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento mensile");
                                LocalDate inizioAbbonMens = LocalDate.parse(scanner.next());
                                Tessera tesseraUtenteRegistratoFromDb = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());

                                TitoloViaggio abbonamentoMensile = new Abbonamento(LocalDate.now(), pe1, TipoAbbonamento.MENSILE, tesseraUtenteRegistratoFromDb, inizioAbbonMens);
                                titoloViaggioDao.save(abbonamentoMensile);
                                System.out.println("Abbonamento acquistato correttamente" + abbonamentoMensile);
                                break;
                            case 3:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento settimanale");
                                LocalDate inizioAbbonSett = LocalDate.parse(scanner.next());
                                Tessera tesseraUtenteRegistratoFromDb2 = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());

                                TitoloViaggio abbonamentoSettimanale = new Abbonamento(LocalDate.now(), pe1, TipoAbbonamento.SETTIMANALE, tesseraUtenteRegistratoFromDb2, inizioAbbonSett);
                                titoloViaggioDao.save(abbonamentoSettimanale);
                                TitoloViaggio abbonamentoSettFromDb = titoloViaggioDao.findById(abbonamentoSettimanale.getId().toString());
                                System.out.println("Abbonamento acquistato correttamente" + abbonamentoSettFromDb);
                                break;
                            case 4:
                                Tessera tesseraUtenteRegistratoFromDb3 = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());
                                if (tesseraUtenteRegistratoFromDb3.getDataScadenza().isAfter(LocalDate.now())) {
                                    System.out.println("La tua tessera è valida fino al " + tesseraUtenteRegistratoFromDb3.getDataScadenza());
                                } else {
                                    System.out.println("Tessera non valida");
                                }
                                break;
                            case 5:
                                Tessera tesseraUtenteRegistratoFromDb4 = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());
                                System.out.println("I tuoi abbonamenti: " + titoloViaggioDao.abbonamentoByIdTessera(tesseraUtenteRegistratoFromDb4.getId().toString()));
                                break;
                            default:
                                System.out.println("Scelta non valida");
                        }
                    } while (sceltaUtente != 0);
                    break;


                case 2:
                    System.out.println("Area Amministratore");
                    System.out.println("Inserisci email");
                    String emailAmm = scanner.nextLine();
                    System.out.println("Inserisci password");
                    String pwAmm = scanner.nextLine();
                    break;


                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        } while (scelta != 0);


    }
}

package Team3;

import Team3.Dao.MezzoDiTrasportoDao;
import Team3.entities.*;
import Team3.enums.StatoDistributore;
import Team3.enums.StatoMezzo;
import Team3.enums.TipoAbbonamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4buildweekpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        MezzoDiTrasportoDao mezzoDao = new MezzoDiTrasportoDao(em);

        // OGGETTI TESSERA ANCORA NON MANAGED

        Tessera tessera1 = new Tessera(LocalDate.of(2026, 4, 20));
        Tessera tessera2 = new Tessera(LocalDate.of(2024, 6, 18));
        Tessera tessera3 = new Tessera(LocalDate.of(2025, 5, 3));
        Tessera tessera4 = new Tessera(LocalDate.of(2025, 8, 19));
        Tessera tessera5 = new Tessera(LocalDate.of(2025, 11, 12));
        Tessera tessera6 = new Tessera(LocalDate.of(2026, 1, 5));
        Tessera tessera7 = new Tessera(LocalDate.of(2026, 3, 30));
        Tessera tessera8 = new Tessera(LocalDate.of(2026, 5, 14));
        Tessera tessera9 = new Tessera(LocalDate.of(2026, 6, 22));
        Tessera tessera10 = new Tessera(LocalDate.of(2025, 2, 15));

        // OGGETTI UTENTE NON ANCORA MANAGED

        Utente u1 = new Utente("aldo", "baglio", tessera1);
        Utente u2 = new Utente("giovanni", "storti", tessera2);
        Utente u3 = new Utente("giacomo", "poretti", tessera3);
        Utente u4 = new Utente("antonio", "albanese", tessera4);
        Utente u5 = new Utente("claudio", "bisio", tessera5);
        Utente u6 = new Utente("leonardo", "dicaprio", tessera6);
        Utente u7 = new Utente("brad", "pitt", tessera7);
        Utente u8 = new Utente("morgan", "freeman", tessera8);
        Utente u9 = new Utente("tom", "hanks", tessera9);
        Utente u10 = new Utente("robert", "deniro", tessera10);

        // OGGETTI PUNTIdiEMISSIONE NON ANCORA MANAGED

        Distributore distr1 = new Distributore("TicketNapoli_Centrale", StatoDistributore.ATTIVO);
        Distributore distr2 = new Distributore("TicketMilano_Centrale", StatoDistributore.FUORI_SERVIZIO);
        Distributore distr3 = new Distributore("MetroRoma_Termini", StatoDistributore.ATTIVO);
        Distributore distr4 = new Distributore("CinemaFellini_Kiosk", StatoDistributore.FUORI_SERVIZIO);
        Distributore distr5 = new Distributore("Trenitalia_SelfService", StatoDistributore.ATTIVO);
        Rivenditore rivend1 = new Rivenditore("Tabaccheria", "tabaccheria Napoli");
        Rivenditore rivend2 = new Rivenditore("Edicola Stazione", "Piazza Garibaldi, Roma");
        Rivenditore rivend3 = new Rivenditore("Bar del Corso", "Corso Umberto I, Torino");
        Rivenditore rivend4 = new Rivenditore("Tabaccheria Toledo", "Via Toledo, Firenze");
        Rivenditore rivend5 = new Rivenditore("Ricevitoria Vomero", "Via Scarlatti, Genova");

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

        // OGGETTI ABBONAMENTO e BIGLIETTO NON ANCORA MANAGED

        Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 5, 10), distr1, true, null, tram1);
        Biglietto biglietto2 = new Biglietto(LocalDate.of(2026, 1, 12), rivend1, false, LocalDate.of(2026, 3, 1),
                tram2);
        Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 8), distr2, false, LocalDate.of(2026, 4, 13), bus1);
        Biglietto biglietto4 = new Biglietto(LocalDate.of(2026, 4, 2), rivend2, true, null, bus2);
        Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 3, 21), rivend3, true, null, tram3);
        Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 6, 3), distr3, TipoAbbonamento.SETTIMANALE,
                tessera1); // Questo sarà SCADUTA
        Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2026, 5, 20), distr3, TipoAbbonamento.MENSILE,
                tessera2); // Questo sarà SCADUTA
        Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2026, 6, 23), distr3, TipoAbbonamento.SETTIMANALE,
                tessera3); // VALIDO non scaduta
        Abbonamento abbonamento4 = new Abbonamento(LocalDate.of(2026, 6, 20), distr3, TipoAbbonamento.MENSILE,
                tessera4); //VALIDO non scaduto
        Abbonamento abbonamento5 = new Abbonamento(LocalDate.of(2026, 3, 15), distr3, TipoAbbonamento.MENSILE,
                tessera5); // SCADUTO non valido

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

        // OGGETTI STORICO MEZZI NON MANAGED

        StoricoMezzo storico1 = new StoricoMezzo(tram1, LocalDate.of(2026, 6, 26), null);
        StoricoMezzo storico2 = new StoricoMezzo(bus1, LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 11));
        StoricoMezzo storico3 = new StoricoMezzo(tram2, LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 2));
        StoricoMezzo storico4 = new StoricoMezzo(bus2, LocalDate.of(2026, 6, 12), LocalDate.of(2026, 6, 13));
        StoricoMezzo storico5 = new StoricoMezzo(tram3, LocalDate.of(2026, 6, 25), null);
        StoricoMezzo storico6 = new StoricoMezzo(bus3, LocalDate.of(2026, 6, 26), null);
        StoricoMezzo storico7 = new StoricoMezzo(tram4, LocalDate.of(2026, 5, 20), LocalDate.of(2026, 5, 21));
        StoricoMezzo storico8 = new StoricoMezzo(bus4, LocalDate.of(2026, 6, 5), LocalDate.of(2026, 6, 6));
        StoricoMezzo storico9 = new StoricoMezzo(tram5, LocalDate.of(2026, 6, 25), null);
        StoricoMezzo storico10 = new StoricoMezzo(bus5, LocalDate.of(2026, 6, 26), null);

        // OGGETTI PERCORRENZA NON MANAGED

        Percorrenza percorrenza1 = new Percorrenza(tratta1, tram1, 30, LocalDate.of(2026, 6, 22)); // IN ANTICIPO
        Percorrenza percorrenza2 = new Percorrenza(tratta2, tram2, 20, LocalDate.of(2026, 6, 23)); // IN ORARIO
        Percorrenza percorrenza3 = new Percorrenza(tratta3, bus1, 22, LocalDate.of(2026, 6, 24)); // IN RITARDO
        Percorrenza percorrenza4 = new Percorrenza(tratta4, bus2, 21, LocalDate.of(2026, 6, 25)); // IN ANTICIPO
        Percorrenza percorrenza5 = new Percorrenza(tratta5, tram3, 12, LocalDate.of(2026, 6, 26)); // IN ORARIO
        Percorrenza percorrenza6 = new Percorrenza(tratta6, tram4, 19, LocalDate.of(2026, 6, 27)); // IN RITARDO
        Percorrenza percorrenza7 = new Percorrenza(tratta7, tram5, 35, LocalDate.of(2026, 6, 28)); // IN RITARDO
        Percorrenza percorrenza8 = new Percorrenza(tratta8, bus3, 45, LocalDate.of(2026, 6, 29)); // IN ORARIO
        Percorrenza percorrenza9 = new Percorrenza(tratta9, bus4, 18, LocalDate.of(2026, 6, 30)); // IN ANTICIPO
        Percorrenza percorrenza10 = new Percorrenza(tratta10, bus5, 25, LocalDate.of(2026, 5, 27)); // IN RITARDO
    }
}

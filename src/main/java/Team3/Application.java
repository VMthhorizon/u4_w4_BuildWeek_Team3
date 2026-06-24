package Team3;

import Team3.Dao.*;
import Team3.classes.*;
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

        // UTENTI
        CreateUsers createUsers = new CreateUsers();
        List<Utente> utenti = createUsers.createUtente(utenteDao);

        // TESSERE
        CreateTessere createTessere = new CreateTessere();
        List<Tessera> tessera = createTessere.createTessera(tesseraDao, utenti);

        // PUNTI DI EMISSIONE
        CreatePuntiDiEmissione createPuntiDiEmissione = new CreatePuntiDiEmissione();
        List<PuntoDiEmissione> puntoDiEmissione = createPuntiDiEmissione.createPuntiDiEmissione(puntoEmissioneDao);

        // MEZZI
        CreateMezzo createMezzo = new CreateMezzo();
        List<MezzoDiTrasporto> mezzo = createMezzo.createMezzo(mezzoDao);

        // TITOLO VIAGGIO
        CreateTitoloViaggio createTitoloViaggio = new CreateTitoloViaggio();
        List<TitoloViaggio> titoloViaggio = createTitoloViaggio.createTitoloViaggio(titoloViaggioDao, puntoDiEmissione, mezzo, tessera);

        // TRATTA
        CreateTratta createTratta = new CreateTratta();
        List<Tratta> tratta = createTratta.createTratta(trattaDao);

        // STORICO MEZZI
        CreateStoricoMezzo createStoricoMezzo = new CreateStoricoMezzo();
        List<StoricoMezzo> storicoMezzo = createStoricoMezzo.createStoricoMezzo(storicoMezzoDao, mezzo);

        // PERCORRENZA
        CreatePercorrenza createPercorrenza = new CreatePercorrenza();
        List<Percorrenza> percorrenza = createPercorrenza.createPercorrenza(percorrenzaDao, tratta, mezzo);

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
        int sceltaAmm;
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
                                TitoloViaggio titoloViaggioScanner = new Biglietto(LocalDate.now(), puntoDiEmissione.get(0), false, null, mezzo.get(1));
                                titoloViaggioDao.save(titoloViaggioScanner);
                                System.out.println("Biglietto acquistato correttamente");
                                break;
                            case 2:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento mensile");
                                LocalDate inizioAbbonMens = LocalDate.parse(scanner.next());
                                Tessera tesseraUtenteRegistratoFromDb = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());

                                TitoloViaggio abbonamentoMensile = new Abbonamento(LocalDate.now(), puntoDiEmissione.get(0), TipoAbbonamento.MENSILE, tesseraUtenteRegistratoFromDb, inizioAbbonMens);
                                titoloViaggioDao.save(abbonamentoMensile);
                                System.out.println("Abbonamento acquistato correttamente" + abbonamentoMensile);
                                break;
                            case 3:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento settimanale");
                                LocalDate inizioAbbonSett = LocalDate.parse(scanner.next());
                                Tessera tesseraUtenteRegistratoFromDb2 = tesseraDao.findById(tesseraUtenteRegistrato.getId().toString());

                                TitoloViaggio abbonamentoSettimanale = new Abbonamento(LocalDate.now(), puntoDiEmissione.get(0), TipoAbbonamento.SETTIMANALE, tesseraUtenteRegistratoFromDb2, inizioAbbonSett);
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

                    do {
                        System.out.println("""
                                1. Registra utente
                                2. Emetti tessera
                                3. Crea distributore
                                4. Crea rivenditore
                                5. Registra autobus
                                6. Registra tram
                                7. Registra tratta
                                8. Registra percorrenza
                                9. Metti mezzo in manutenzione
                                10. Riattiva mezzo
                                11. Statistiche
                                0. Torna indietro
                                """);
                        sceltaAmm = Integer.parseInt(scanner.nextLine());

                        switch (sceltaAmm) {
                            case 1:
                                System.out.println("Inserisci il nome dell'utente da registrare");
                                String nomeNuovo = scanner.nextLine();
                                System.out.println("Inserisci il cognome dell'utente da registrare");
                                String cognomeNuovo = scanner.nextLine();
                                Utente utenteNuovo = new Utente(nomeNuovo, cognomeNuovo);
                                utenteDao.save(utenteNuovo);

                                System.out.println("Utente inserito con successo" + utenteNuovo);
                                break;
                            case 2:
                                System.out.println("Inserisci l'id dell'utente");
                                String idUtente = scanner.nextLine();
                                Utente utenteNuovoFromDb = utenteDao.findById(idUtente);
                                Tessera tesseraScanner = new Tessera(LocalDate.now(), utenteNuovoFromDb);
                            default:
                                System.out.println("Scelta non valida");
                        }


                    } while (sceltaAmm != 0);


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

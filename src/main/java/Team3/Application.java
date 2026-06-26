package Team3;

import Team3.Dao.*;
import Team3.classes.*;
import Team3.entities.*;
import Team3.enums.StatoDistributore;
import Team3.enums.StatoMezzo;
import Team3.enums.TipoAbbonamento;
import com.github.javafaker.Faker;
import Team3.exceptions.NotADateException;
import Team3.exceptions.NotANumberException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4buildweekpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        Faker faker = new Faker(Locale.ITALY);

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
        List<Utente> utenti = createUsers.createUtente(utenteDao, faker);

        // TESSERE
        CreateTessere createTessere = new CreateTessere();
        List<Tessera> tessera = createTessere.createTessera(tesseraDao, utenti, faker);

        // PUNTI DI EMISSIONE
        CreatePuntiDiEmissione createPuntiDiEmissione = new CreatePuntiDiEmissione();
        List<PuntoDiEmissione> puntoDiEmissione = createPuntiDiEmissione.createPuntiDiEmissione(puntoEmissioneDao,
                faker);

        // MEZZI
        CreateMezzo createMezzo = new CreateMezzo();
        List<MezzoDiTrasporto> mezzo = createMezzo.createMezzo(mezzoDao, faker);

        // TITOLO VIAGGIO
        CreateTitoloViaggio createTitoloViaggio = new CreateTitoloViaggio();
        List<TitoloViaggio> titoloViaggio = createTitoloViaggio.createTitoloViaggio(titoloViaggioDao, puntoDiEmissione,
                mezzo, tessera, faker);

        // TRATTA
        CreateTratta createTratta = new CreateTratta();
        List<Tratta> tratta = createTratta.createTratta(trattaDao, faker);

        // STORICO MEZZI
        CreateStoricoMezzo createStoricoMezzo = new CreateStoricoMezzo();
        List<StoricoMezzo> storicoMezzo = createStoricoMezzo.createStoricoMezzo(storicoMezzoDao, mezzo, faker);

        // PERCORRENZA
        CreatePercorrenza createPercorrenza = new CreatePercorrenza();
        List<Percorrenza> percorrenza = createPercorrenza.createPercorrenza(percorrenzaDao, tratta, mezzo, faker);

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
        System.out.println(" ");
        System.out.println("Login");
        int scelta = 0;
        int sceltaUtente;
        int sceltaAmm;
        do {
            System.out.println("""
                    1. Area Utente
                    2. Area Amministratore
                    0. Esci
                    """);

            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserisci un numero intero valido!");
                scelta = -1;
                continue;
            }

            switch (scelta) {
                case 1:
                    System.out.println("Area Utente");
                    System.out.println("Inserisci i tuoi dati per registrarti come utente");

                    String nome = "";
                    while (nome.trim()
                            .isEmpty()) {
                        System.out.print("nome: ");
                        nome = scanner.nextLine();
                        if (nome.trim()
                                .isEmpty()) {
                            System.out.println("Errore: Il nome non può essere vuoto!");
                        }
                    }

                    String cognome = "";
                    while (cognome.trim()
                            .isEmpty()) {
                        System.out.print("cognome: ");
                        System.out.println("");
                        cognome = scanner.nextLine();
                        if (cognome.trim()
                                .isEmpty()) {
                            System.out.println("Errore: Il cognome non può essere vuoto!");
                        }
                    }

                    Utente utenteRegistrato = new Utente(nome, cognome);
                    utenteDao.save(utenteRegistrato);
                    Tessera tesseraUtenteRegistrato = null;

                    System.out.println(" ");

                    int sceltaTessera = -1;
                    while (sceltaTessera != 1 && sceltaTessera != 2) {
                        System.out.println("""
                                Vuoi anche una tessera?
                                1 - SI
                                2 - NO
                                """);
                        try {
                            sceltaTessera = Integer.parseInt(scanner.nextLine());
                            if (sceltaTessera != 1 && sceltaTessera != 2) {
                                System.out.println("Errore: Inserisci 1 per SI o 2 per NO.\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: Inserisci un numero valido (1 o 2)!\n");
                            sceltaTessera = -1;
                        }
                    }

                    if (sceltaTessera == 1) {
                        tesseraUtenteRegistrato = new Tessera(LocalDate.now(), utenteRegistrato);
                        tesseraDao.save(tesseraUtenteRegistrato);
                    } else {
                        System.out.println("Registrazione completata senza emissione di tessera.");
                    }
                    do {
                        System.out.println(" ");
                        System.out.println("""
                                1. Acquista biglietto
                                2. Acquista abbonamento mensile
                                3. Acquista abbonamento settimanale
                                4. Controlla validità tessera
                                5. I miei abbonamenti
                                0. Esci
                                """);

                        try {
                            sceltaUtente = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: Inserisci un numero intero valido!\n");
                            sceltaUtente = -1;
                            continue;
                        }
                        switch (sceltaUtente) {
                            case 1:
                                int peSelezionato = -1;
                                while (peSelezionato < 0 || peSelezionato >= puntoDiEmissione.size()) {
                                    System.out.println("Scegli un punto di emissione");
                                    for (int i = 0; i < puntoDiEmissione.size(); i++) {
                                        System.out.println((i + 1) + " " + puntoDiEmissione.get(i)
                                                .getNome());
                                    }
                                    try {
                                        peSelezionato = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (peSelezionato < 0 || peSelezionato >= puntoDiEmissione.size()) {
                                            System.out.println(
                                                    "Errore: Numero non valido! Scegli un numero tra 1 e " + puntoDiEmissione.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        peSelezionato = -1;
                                    }
                                }
                                int mezzoSelezionato = -1;
                                while (mezzoSelezionato < 0 || mezzoSelezionato >= mezzo.size()) {
                                    System.out.println("Scegli un mezzo");
                                    for (int i = 0; i < mezzo.size(); i++) {
                                        if (mezzo.get(i)
                                                .getStato() == StatoMezzo.SERVIZIO) {
                                            System.out.println((i + 1) + " " + mezzo.get(i)
                                                    .getClass()
                                                    .getSimpleName() + " " + mezzo.get(i)
                                                    .getId_mezzo());
                                        }

                                    }
                                    try {
                                        mezzoSelezionato = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (mezzoSelezionato < 0 || mezzoSelezionato >= mezzo.size()) {
                                            System.out.println(
                                                    "Errore: Numero mezzo non valido! Scegli un numero tra 1 e " + mezzo.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        mezzoSelezionato = -1;
                                    }
                                }

                                TitoloViaggio titoloViaggio1 = new Biglietto(LocalDate.now(),
                                        puntoDiEmissione.get(peSelezionato),
                                        false, null, mezzo.get(mezzoSelezionato));
                                titoloViaggioDao.save(titoloViaggio1);
                                System.out.println("Biglietto acquistato correttamente");
                                break;
                            case 2:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento mensile");


                                LocalDate inizioAbbonMens = null;
                                while (inizioAbbonMens == null) {
                                    System.out.print("Inserisci la data (formato AAAA-MM-GG, es. 2026-06-24): ");
                                    try {
                                        inizioAbbonMens = LocalDate.parse(scanner.nextLine());
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println(
                                                "Errore: Formato data non valido! Usa il formato ISO (AAAA-MM-GG).");
                                    }
                                }
                                if (inizioAbbonMens.isBefore(LocalDate.now())) {
                                    System.out.println(
                                            "Hai inserito una data già passata. Perfavore inserisci una data futura");
                                    break;
                                }
                                Tessera tesseraUtenteRegistratoFromDb = tesseraDao.findById(
                                        tesseraUtenteRegistrato.getId()
                                                .toString());
                                TitoloViaggio abbonamentoMensile = new Abbonamento(LocalDate.now(),
                                        puntoDiEmissione.get(1), TipoAbbonamento.MENSILE, tesseraUtenteRegistratoFromDb,
                                        inizioAbbonMens);

                                titoloViaggioDao.save(abbonamentoMensile);
                                System.out.println("Abbonamento acquistato correttamente: " + abbonamentoMensile);
                                break;
                            case 3:
                                System.out.println("Scegli la data di inizio validità del tuo abbonamento settimanale");


                                LocalDate inizioAbbonSett = null;
                                while (inizioAbbonSett == null) {
                                    System.out.print("Inserisci la data (formato AAAA-MM-GG, es. 2026-06-24): ");
                                    try {
                                        inizioAbbonSett = LocalDate.parse(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println(
                                                "Errore: Formato data non valido! Usa il formato ISO (AAAA-MM-GG).");
                                    }
                                }
                                if (inizioAbbonSett.isBefore(LocalDate.now())) {
                                    System.out.println(
                                            "Hai inserito una data già passata. Perfavore inserisci una data futura");
                                    break;
                                }
                                Tessera tesseraUtenteRegistratoFromDb2 = tesseraDao.findById(
                                        tesseraUtenteRegistrato.getId()
                                                .toString());
                                TitoloViaggio abbonamentoSettimanale = new Abbonamento(LocalDate.now(),
                                        puntoDiEmissione.get(0), TipoAbbonamento.SETTIMANALE,
                                        tesseraUtenteRegistratoFromDb2, inizioAbbonSett);
                                titoloViaggioDao.save(abbonamentoSettimanale);
                                TitoloViaggio abbonamentoSettFromDb = titoloViaggioDao.findById(
                                        abbonamentoSettimanale.getId()
                                                .toString());
                                System.out.println("Abbonamento acquistato correttamente: " + abbonamentoSettFromDb);

                                break;
                            case 4:
                                Tessera tesseraUtenteRegistratoFromDb3 = tesseraDao.findById(
                                        tesseraUtenteRegistrato.getId()
                                                .toString());
                                if (tesseraUtenteRegistratoFromDb3.getDataScadenza()
                                        .isAfter(LocalDate.now())) {
                                    System.out.println(
                                            "La tua tessera è valida fino al " + tesseraUtenteRegistratoFromDb3.getDataScadenza());
                                } else {
                                    System.out.println("Tessera non valida");
                                }
                                break;
                            case 5:
                                Tessera tesseraUtenteRegistratoFromDb4 = tesseraDao.findById(
                                        tesseraUtenteRegistrato.getId()
                                                .toString());
                                System.out.println("I tuoi abbonamenti: " + titoloViaggioDao.abbonamentoByIdTessera(
                                        tesseraUtenteRegistratoFromDb4.getId()
                                                .toString()));
                                break;
                            case 0:
                                System.out.println("Menù iniziale:");
                                break;
                            default:
                                System.out.println("Scelta non valida");
                        }
                    } while (sceltaUtente != 0);
                    break;
                case 2:
                    System.out.println("Area Amministratore");

                    String emailAmm = "";
                    while (emailAmm.trim()
                            .isEmpty()) {
                        System.out.println("Inserisci email:");
                        emailAmm = scanner.nextLine();
                        if (emailAmm.trim()
                                .isEmpty()) {
                            System.out.println("Errore: L'email non può essere vuota!");
                        }
                    }

                    String pwAmm = "";
                    while (pwAmm.trim()
                            .isEmpty()) {
                        System.out.println("Inserisci password:");
                        pwAmm = scanner.nextLine();
                        if (pwAmm.trim()
                                .isEmpty()) {
                            System.out.println("Errore: La password non può essere vuota!");
                        }
                    }

                    if (!emailAmm.equals("amministratore@gmail.com") || !pwAmm.equals("1234")) {
                        System.out.println("Dati inseriti errati, riprova");
                        break;
                    }
                    System.out.println("Login effettuato con successo");

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
                                11. Controllo tessera
                                12. Statistiche
                                0. Torna indietro
                                """);

                        try {
                            sceltaAmm = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: Inserisci un numero intero valido!\n");
                            sceltaAmm = -1;
                            continue;
                        }

                        switch (sceltaAmm) {
                            case 1:
                                String nomeNuovo = "";
                                while (nomeNuovo.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il nome dell'utente da registrare:");
                                    nomeNuovo = scanner.nextLine();
                                    if (nomeNuovo.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il nome non può essere vuoto!");
                                    }
                                }

                                String cognomeNuovo = "";
                                while (cognomeNuovo.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il cognome dell'utente da registrare:");
                                    cognomeNuovo = scanner.nextLine();
                                    if (cognomeNuovo.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il cognome non può essere vuoto!");
                                    }
                                }

                                Utente utenteNuovo = new Utente(nomeNuovo, cognomeNuovo);
                                utenteDao.save(utenteNuovo);

                                System.out.println("Utente inserito con successo: " + utenteNuovo);
                                break;
                            case 2:
                                String idUtente = "";
                                while (idUtente.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci l'id dell'utente:");
                                    idUtente = scanner.nextLine();
                                    if (idUtente.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: L'ID non può essere vuoto!");
                                    }
                                }

                                Utente utenteNuovoFromDb = utenteDao.findById(idUtente);

                                if (utenteNuovoFromDb == null) {
                                    System.out.println("Errore: Nessun utente trovato con questo ID!");
                                    break; // Torna al menu amministratore senza salvare nulla
                                }

                                Tessera tesseraNuovoUtente = new Tessera(LocalDate.now(), utenteNuovoFromDb);
                                tesseraDao.save(tesseraNuovoUtente);
                                System.out.println(
                                        "Tessera emessa con successo per l'utente " + utenteNuovoFromDb.getNome());
                                break;
                            case 3:
                                String nomeDistr = "";
                                while (nomeDistr.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il nome del nuovo distributore:");
                                    nomeDistr = scanner.nextLine();
                                    if (nomeDistr.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il nome non può essere vuoto!");
                                    }
                                }

                                int sceltaTipoDistr = -1;
                                while (sceltaTipoDistr != 1 && sceltaTipoDistr != 2) {
                                    System.out.println("""
                                            Indica lo stato del distributore:
                                             1 - ATTIVO 
                                             2 - FUORI_SERVIZIO
                                            """);
                                    try {
                                        sceltaTipoDistr = Integer.parseInt(scanner.nextLine());
                                        if (sceltaTipoDistr != 1 && sceltaTipoDistr != 2) {
                                            System.out.println("Errore: Inserisci solo 1 o 2.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        sceltaTipoDistr = -1;
                                    }
                                }

                                Distributore distributore = new Distributore(nomeDistr,
                                        StatoDistributore.values()[sceltaTipoDistr - 1]);
                                puntoEmissioneDao.save(distributore);
                                System.out.println("Distributore creato con successo!");
                                break;
                            case 4:
                                String nomeRiven = "";
                                while (nomeRiven.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il nome del nuovo rivenditore:");
                                    nomeRiven = scanner.nextLine();
                                    if (nomeRiven.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il nome non può essere vuoto!");
                                    }
                                }

                                String indirizzo = "";
                                while (indirizzo.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci l'indirizzo:");
                                    indirizzo = scanner.nextLine();
                                    if (indirizzo.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: L'indirizzo non può essere vuoto!");
                                    }
                                }

                                LocalTime apertura = null;
                                while (apertura == null) {
                                    System.out.println("Inserisci l'orario di apertura (formato HH:MM, es. 08:30):");
                                    try {
                                        apertura = LocalTime.parse(scanner.nextLine());
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println(
                                                "Errore: Formato orario non valido! Usa il formato 24 ore (HH:MM).");
                                    }
                                }

                                LocalTime chiusura = null;
                                while (chiusura == null) {
                                    System.out.println("Inserisci l'orario di chiusura (formato HH:MM, es. 19:30):");
                                    try {
                                        chiusura = LocalTime.parse(scanner.nextLine());
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println(
                                                "Errore: Formato orario non valido! Usa il formato 24 ore (HH:MM).");
                                    }
                                }

                                Rivenditore rivenditore = new Rivenditore(nomeRiven, indirizzo, apertura, chiusura);
                                puntoEmissioneDao.save(rivenditore);
                                System.out.println("Rivenditore registrato con successo!");
                                break;
                            case 5:
                                int capienza = -1;
                                while (capienza <= 0) {
                                    System.out.println("Indica la capienza del mezzo (numero intero positivo):");
                                    try {
                                        capienza = Integer.parseInt(scanner.nextLine());
                                        if (capienza <= 0) {
                                            System.out.println("Errore: La capienza deve essere maggiore di 0.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        capienza = -1;
                                    }
                                }

                                int sceltaStatoMezzo = -1;
                                while (sceltaStatoMezzo != 1 && sceltaStatoMezzo != 2) {
                                    System.out.println("""
                                            Indica lo stato del mezzo:
                                             1 - SERVIZIO 
                                             2 - MANUTENZIONE
                                            """);
                                    try {
                                        sceltaStatoMezzo = Integer.parseInt(scanner.nextLine());
                                        if (sceltaStatoMezzo != 1 && sceltaStatoMezzo != 2) {
                                            System.out.println("Errore: Inserisci solo 1 o 2.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        sceltaStatoMezzo = -1;
                                    }
                                }

                                MezzoDiTrasporto mezzoDiTrasporto = new Autobus(
                                        StatoMezzo.values()[sceltaStatoMezzo - 1], capienza);
                                mezzoDao.save(mezzoDiTrasporto);
                                System.out.println("Autobus registrato con successo!");
                                break;
                            case 6:
                                int capienza2 = -1;
                                while (capienza2 <= 0) {
                                    System.out.println("Indica la capienza del tram (numero intero positivo):");
                                    try {
                                        capienza2 = Integer.parseInt(scanner.nextLine());
                                        if (capienza2 <= 0) {
                                            System.out.println("Errore: La capienza deve essere maggiore di 0.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        capienza2 = -1;
                                    }
                                }

                                int sceltaStatoMezzo2 = -1;
                                while (sceltaStatoMezzo2 != 1 && sceltaStatoMezzo2 != 2) {
                                    System.out.println("""
                                            Indica lo stato del mezzo:
                                             1 - SERVIZIO 
                                             2 - MANUTENZIONE
                                            """);
                                    try {
                                        sceltaStatoMezzo2 = Integer.parseInt(scanner.nextLine());
                                        if (sceltaStatoMezzo2 != 1 && sceltaStatoMezzo2 != 2) {
                                            System.out.println("Errore: Inserisci solo 1 o 2.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        sceltaStatoMezzo2 = -1;
                                    }
                                }

                                MezzoDiTrasporto mezzoTram = new Tram(
                                        StatoMezzo.values()[sceltaStatoMezzo2 - 1], capienza2);
                                mezzoDao.save(mezzoTram);
                                System.out.println("Tram registrato con successo!");
                                break;
                            case 7:
                                String partenza = "";
                                while (partenza.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il punto di partenza:");
                                    partenza = scanner.nextLine();
                                    if (partenza.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il punto di partenza non può essere vuoto!");
                                    }
                                }

                                String capolinea = "";
                                while (capolinea.trim()
                                        .isEmpty()) {
                                    System.out.println("Inserisci il capolinea:");
                                    capolinea = scanner.nextLine();
                                    if (capolinea.trim()
                                            .isEmpty()) {
                                        System.out.println("Errore: Il capolinea non può essere vuoto!");
                                    }
                                }

                                int tPrevisto = -1;
                                while (tPrevisto <= 0) {
                                    System.out.println("Inserisci il tempo previsto (in minuti, intero positivo):");
                                    try {
                                        tPrevisto = Integer.parseInt(scanner.nextLine());
                                        if (tPrevisto <= 0) {
                                            System.out.println(
                                                    "Errore: Il tempo previsto deve essere maggiore di 0.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        tPrevisto = -1;
                                    }
                                }

                                Tratta trattaNuova = new Tratta(partenza, capolinea, tPrevisto);
                                trattaDao.save(trattaNuova);
                                System.out.println("Tratta registrata con successo!");
                                break;
                            case 8:
                                int trattaScelta = -1;
                                while (trattaScelta < 0 || trattaScelta >= tratta.size()) {
                                    System.out.println("Scegli una tratta:");
                                    for (int i = 0; i < tratta.size(); i++) {
                                        System.out.println((i + 1) + " Da " + tratta.get(i)
                                                .getZonaPartenza() +
                                                " a " + tratta.get(i)
                                                .getZonaCapolinea() +
                                                ". Tempo previsto: " + tratta.get(i)
                                                .getTempoPrevisto() + " minuti.");
                                    }
                                    try {
                                        trattaScelta = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (trattaScelta < 0 || trattaScelta >= tratta.size()) {
                                            System.out.println(
                                                    "Errore: Numero tratta non valido! Scegli un numero tra 1 e " + tratta.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        trattaScelta = -1;
                                    }
                                }

                                int mezzoScelto = -1;
                                while (mezzoScelto < 0 || mezzoScelto >= mezzo.size()) {
                                    System.out.println("Scegli un mezzo:");
                                    for (int i = 0; i < mezzo.size(); i++) {
                                        System.out.println((i + 1) + " " + mezzo.get(i));
                                    }
                                    try {
                                        mezzoScelto = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (mezzoScelto < 0 || mezzoScelto >= mezzo.size()) {
                                            System.out.println(
                                                    "Errore: Numero mezzo non valido! Scegli un numero tra 1 e " + mezzo.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        mezzoScelto = -1;
                                    }
                                }

                                int tEffettivo = -1;
                                while (tEffettivo <= 0) {
                                    System.out.println("Inserisci il tempo effettivo in minuti (intero positivo):");
                                    try {
                                        tEffettivo = Integer.parseInt(scanner.nextLine());
                                        if (tEffettivo <= 0) {
                                            System.out.println(
                                                    "Errore: Il tempo effettivo deve essere maggiore di 0.\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        tEffettivo = -1;
                                    }
                                }

                                LocalDate dataPercor = null;
                                while (dataPercor == null) {
                                    System.out.println(
                                            "Inserisci la data della percorrenza (formato AAAA-MM-GG, es. 2026-06-25)" +
                                                    ":");
                                    try {
                                        dataPercor = LocalDate.parse(scanner.nextLine());
                                    } catch (java.time.format.DateTimeParseException e) {
                                        System.out.println(
                                                "Errore: Formato data non valido! Usa il formato ISO (AAAA-MM-GG).\n");
                                    }
                                }

                                Percorrenza percorrenza1 = new Percorrenza(tratta.get(trattaScelta),
                                        mezzo.get(mezzoScelto), tEffettivo, dataPercor);
                                percorrenzaDao.save(percorrenza1);
                                System.out.println("Percorrenza registrata con successo!");
                                break;
                            case 9:

                                int mezzoScelto2 = -1;
                                while (mezzoScelto2 < 0 || mezzoScelto2 >= mezzo.size()) {
                                    System.out.println("Scegli un mezzo da mettere in manutenzione:");
                                    for (int i = 0; i < mezzo.size(); i++) {
                                        System.out.println((i + 1) + " " + mezzo.get(i));
                                    }
                                    try {
                                        mezzoScelto2 = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (mezzoScelto2 < 0 || mezzoScelto2 >= mezzo.size()) {
                                            System.out.println(
                                                    "Errore: Numero mezzo non valido! Scegli un numero tra 1 e " + mezzo.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        mezzoScelto2 = -1;
                                    }
                                }

                                UUID idMezzoFromDb = mezzo.get(mezzoScelto2)
                                        .getId_mezzo();
                                mezzoDao.cambiaStato(idMezzoFromDb, StatoMezzo.MANUTENZIONE);
                                System.out.println("Stato del mezzo aggiornato in MANUTENZIONE.");
                                break;
                            case 10:
                                int mezzoScelto3 = -1;
                                while (mezzoScelto3 < 0 || mezzoScelto3 >= mezzo.size()) {
                                    System.out.println("Scegli un mezzo da rimettere in servizio:");
                                    for (int i = 0; i < mezzo.size(); i++) {
                                        System.out.println((i + 1) + " " + mezzo.get(i));
                                    }
                                    try {
                                        mezzoScelto3 = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (mezzoScelto3 < 0 || mezzoScelto3 >= mezzo.size()) {
                                            System.out.println(
                                                    "Errore: Numero mezzo non valido! Scegli un numero tra 1 e " + mezzo.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        mezzoScelto3 = -1;
                                    }
                                }

                                UUID idMezzoFromDb2 = mezzo.get(mezzoScelto3)
                                        .getId_mezzo();
                                mezzoDao.cambiaStato(idMezzoFromDb2, StatoMezzo.SERVIZIO);
                                System.out.println("Stato del mezzo aggiornato in SERVIZIO.");
                                break;
                            case 11:
                                int utenteScelto = -1;
                                while (utenteScelto < 0 || utenteScelto >= utenti.size()) {
                                    System.out.println("Scegli un utente:");
                                    for (int i = 0; i < utenti.size(); i++) {
                                        System.out.println((i + 1) + " " + utenti.get(i));
                                    }
                                    try {
                                        utenteScelto = Integer.parseInt(scanner.nextLine()) - 1;
                                        if (utenteScelto < 0 || utenteScelto >= utenti.size()) {
                                            System.out.println(
                                                    "Errore: Numero utente non valido! Scegli un numero tra 1 e "
                                                            + utenti.size() + ".\n");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        utenteScelto = -1;
                                    }
                                }
                                Utente utenteSelezionato = utenti.get(utenteScelto);

                                Tessera tesseraSelezionata = tesseraDao.findByUserId(utenteSelezionato.getId()
                                        .toString());
                                System.out.println(
                                        "Tessera Utente id: " + tesseraSelezionata.getId() + " Utente id: " + tesseraSelezionata.getUtente()
                                                .getId());
                                if (tesseraSelezionata.getDataScadenza()
                                        .isBefore(LocalDate.now())) {
                                    System.out.println(
                                            "La tessera selezionata è SCADUTA il: " + tesseraSelezionata
                                                    .getDataScadenza());

                                    int sceltaRinnovo = -1;
                                    while (sceltaRinnovo != 1 && sceltaRinnovo != 2) {
                                        System.out.println("""
                                                Vuoi rinnovare la tessera?
                                                1 - SI
                                                2 - NO
                                                """);
                                        try {
                                            sceltaRinnovo = Integer.parseInt(scanner.nextLine());
                                            if (sceltaRinnovo != 1 && sceltaRinnovo != 2) {
                                                System.out.println("Errore: Inserisci solo 1 per SI o 2 per NO.\n");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Errore: Inserisci un numero valido!\n");
                                            sceltaRinnovo = -1;
                                        }
                                    }

                                    if (sceltaRinnovo == 1) {
                                        Tessera tesseraFromDb = tesseraDao.findById(tesseraSelezionata.getId()
                                                .toString());
                                        if (tesseraFromDb != null) {
                                            Tessera tesseraRinnovata = tesseraDao.setRinnovoTessera(
                                                    tesseraFromDb.getId()
                                                            .toString(), LocalDate.now());
                                            System.out.println("Operazione completata con successo.\n" +
                                                    "La Tessera ora scadrà il: " + tesseraRinnovata.getDataScadenza());
                                        } else {
                                            System.out.println("Errore: Impossibile trovare la tessera nel Database.");
                                        }
                                    } else {
                                        System.out.println("Rinnovo annullato.");
                                    }

                                } else {
                                    System.out.println(
                                            "La tessera è REGOLARE. Scade il: " + tesseraSelezionata
                                                    .getDataScadenza());
                                }
                                break;
                            case 12:
                                int choice = -1;
                                do {
                                    System.out.println("""
                                            Quale statistica vuoi conoscere?
                                            Digita 1 per sapere i periodi di MANUTENZIONE di un mezzo
                                            Digita 2 per sapere i periodi di SERVIZIO di un mezzo
                                            Digita 3 per sapere quanti biglietti sono stati VIDIMATI in un certo PERIODO
                                            Digita 4 per sapere quanti biglietti sono stati VIDIMATI su un mezzo
                                            Digita 5 per sapere il TOTALE delle TRATTE di un mezzo
                                            Digita 6 per sapere il TEMPO EFFETTIVO TOTALE di un MEZZO su una TRATTA
                                            """);

                                    try {
                                        choice = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Errore: Inserisci un numero intero valido!\n");
                                        choice = -1;
                                        continue;
                                    }
                                    switch (choice) {
                                        case 1:
                                            int mezzoSelezionato = -1;
                                            while (mezzoSelezionato < 0 || mezzoSelezionato >= mezzo.size()) {
                                                System.out.println("Scegli un mezzo:");
                                                for (int i = 0; i < mezzo.size(); i++) {
                                                    System.out.println((i + 1) + " " + mezzo.get(i));
                                                }
                                                try {
                                                    mezzoSelezionato = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (mezzoSelezionato < 0 || mezzoSelezionato >= mezzo.size()) {
                                                        System.out.println(
                                                                "Errore: Numero mezzo non valido! Scegli un numero " +
                                                                        "tra 1 e " + mezzo.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    mezzoSelezionato = -1;
                                                }
                                            }

                                            UUID idMezzoFromDatabase = mezzo.get(mezzoSelezionato)
                                                    .getId_mezzo();
                                            if (storicoMezzoDao.findPeriodiManutenzione(idMezzoFromDatabase)
                                                    .isEmpty()) {
                                                System.out.println("Questo non é mai stato in MANUTENZIONE");
                                                break;
                                            }
                                            storicoMezzoDao.findPeriodiManutenzione(idMezzoFromDatabase)
                                                    .forEach(System.out::println);
                                            break;
                                        case 2:
                                            int mezzoSelezionato1 = -1;
                                            while (mezzoSelezionato1 < 0 || mezzoSelezionato1 >= mezzo.size()) {
                                                System.out.println("Scegli un mezzo:");
                                                for (int i = 0; i < mezzo.size(); i++) {
                                                    System.out.println((i + 1) + " " + mezzo.get(i));
                                                }
                                                try {
                                                    mezzoSelezionato1 = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (mezzoSelezionato1 < 0 || mezzoSelezionato1 >= mezzo.size()) {
                                                        System.out.println(
                                                                "Errore: Numero mezzo non valido! Scegli un numero " +
                                                                        "tra 1 e " + mezzo.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    mezzoSelezionato1 = -1;
                                                }
                                            }

                                            UUID idMezzoFromDatabase1 = mezzo.get(mezzoSelezionato1)
                                                    .getId_mezzo();
                                            if (storicoMezzoDao.findPeriodiManutenzione(idMezzoFromDatabase1)
                                                    .isEmpty()) {
                                                System.out.println("Questo non é mai stato in SERVIZIO");
                                                break;
                                            }
                                            storicoMezzoDao.findPeriodiServizio(idMezzoFromDatabase1)
                                                    .forEach(System.out::println);
                                            break;
                                        case 3:
                                            LocalDate dataInizio = null;
                                            while (dataInizio == null) {
                                                System.out.println(
                                                        "Scegli una data di inizio (formato AAAA-MM-GG, es. " +
                                                                "2026-01-01): ");
                                                try {
                                                    dataInizio = LocalDate.parse(scanner.nextLine());
                                                } catch (java.time.format.DateTimeParseException e) {
                                                    System.out.println(
                                                            "ERRORE! Formato data non valido. Usare il formato: " +
                                                                    "AAAA-MM-GG;\n");
                                                }
                                            }

                                            LocalDate dataFine = null;
                                            while (dataFine == null) {
                                                System.out.println(
                                                        "Scegli una data di fine (formato AAAA-MM-GG, es. 2026-12-31)" +
                                                                ": ");
                                                try {
                                                    dataFine = LocalDate.parse(scanner.nextLine());
                                                    if (dataFine.isBefore(dataInizio)) {
                                                        System.out.println(
                                                                "Errore: La data di fine non può essere precedente " +
                                                                        "alla data di inizio!\n");
                                                        dataFine = null;
                                                    }
                                                } catch (java.time.format.DateTimeParseException e) {
                                                    System.out.println(
                                                            "ERRORE! Formato data non valido. Usare il formato: " +
                                                                    "AAAA-MM-GG;\n");
                                                }
                                            }

                                            long totBigliettiVidimiati = titoloViaggioDao.totaleBigliettiVidimatiByDate(
                                                    dataInizio, dataFine);
                                            if (totBigliettiVidimiati > 1) {
                                                System.out.println(
                                                        "Sono stati vidimati " + totBigliettiVidimiati + " biglietti " +
                                                                "dal "
                                                                + dataInizio + " al " + dataFine);
                                            } else if (totBigliettiVidimiati == 0) {
                                                System.out.println(
                                                        "Non sono stati VIDIMATI biglietti dal " + dataInizio + " al "
                                                                + dataFine);
                                            } else {
                                                System.out.println(
                                                        "E' stato VIDIMATO un solo BIGLIETTO");
                                            }
                                            break;
                                        case 4:
                                            int mezzoSelezionato2 = -1;
                                            while (mezzoSelezionato2 < 0 || mezzoSelezionato2 >= mezzo.size()) {
                                                System.out.println("Scegli un mezzo:");
                                                for (int i = 0; i < mezzo.size(); i++) {
                                                    System.out.println((i + 1) + " " + mezzo.get(i));
                                                }
                                                try {
                                                    mezzoSelezionato2 = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (mezzoSelezionato2 < 0 || mezzoSelezionato2 >= mezzo.size()) {
                                                        System.out.println(
                                                                "Errore: Numero mezzo non valido! Scegli un numero " +
                                                                        "tra 1 e " + mezzo.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    mezzoSelezionato2 = -1;
                                                }
                                            }

                                            String idMezzoFromDatabase2 = mezzo.get(mezzoSelezionato2)
                                                    .getId_mezzo()
                                                    .toString();
                                            Long totBigliettiVidimati = titoloViaggioDao.totaleBigliettiVidimatiByMezzo(
                                                    idMezzoFromDatabase2);
                                            if (totBigliettiVidimati > 1) {
                                                System.out.println(
                                                        "Sono stati VIDIMATI in totale " + totBigliettiVidimati +
                                                                " biglietti sul mezzo con id: " + idMezzoFromDatabase2);
                                            } else if (totBigliettiVidimati == 0) {
                                                System.out.println(
                                                        "Non sono stati VIDIMATI biglietti sul mezzo con id: " + idMezzoFromDatabase2);
                                            } else {
                                                System.out.println(
                                                        "E' stato VIDIMATO un solo BIGLIETTO sul mezzo con id: " + idMezzoFromDatabase2);
                                            }
                                            break;
                                        case 5:
                                            int mezzoSelezionato3 = -1;
                                            while (mezzoSelezionato3 < 0 || mezzoSelezionato3 >= mezzo.size()) {
                                                System.out.println("Scegli un mezzo:");
                                                for (int i = 0; i < mezzo.size(); i++) {
                                                    System.out.println((i + 1) + " " + mezzo.get(i));
                                                }
                                                try {
                                                    mezzoSelezionato3 = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (mezzoSelezionato3 < 0 || mezzoSelezionato3 >= mezzo.size()) {
                                                        System.out.println(
                                                                "Errore: Numero mezzo non valido! Scegli un numero " +
                                                                        "tra 1 e " + mezzo.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    mezzoSelezionato3 = -1;
                                                }
                                            }

                                            String idMezzoFromDatabase3 = mezzo.get(mezzoSelezionato3)
                                                    .getId_mezzo()
                                                    .toString();
                                            Long totTratteMezzo = mezzoDao.countTratteByMezzo(idMezzoFromDatabase3);
                                            if (totTratteMezzo > 1) {
                                                System.out.println(
                                                        "Il mezzo con id: " + idMezzoFromDatabase3 + " ha percorso " + totTratteMezzo + " tratte");
                                            } else if (totTratteMezzo == 0) {
                                                System.out.println(
                                                        "Il mezzo con id: " + idMezzoFromDatabase3 + " non ha " +
                                                                "percorso TRATTE");
                                            } else {
                                                System.out.println(
                                                        "Il mezzo con id: " + idMezzoFromDatabase3 + " ha percorso " +
                                                                "UNA SOLA tratta");
                                            }
                                            break;
                                        case 6:
                                            int mezzoSelezionato4 = -1;
                                            while (mezzoSelezionato4 < 0 || mezzoSelezionato4 >= mezzo.size()) {
                                                System.out.println("Scegli un mezzo:");
                                                for (int i = 0; i < mezzo.size(); i++) {
                                                    System.out.println((i + 1) + " " + mezzo.get(i));
                                                }
                                                try {
                                                    mezzoSelezionato4 = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (mezzoSelezionato4 < 0 || mezzoSelezionato4 >= mezzo.size()) {
                                                        System.out.println(
                                                                "Errore: Numero mezzo non valido! Scegli un numero " +
                                                                        "tra 1 e " + mezzo.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    mezzoSelezionato4 = -1;
                                                }
                                            }

                                            int trattaSelezionata = -1;
                                            while (trattaSelezionata < 0 || trattaSelezionata >= tratta.size()) {
                                                System.out.println("Scegli una tratta:");
                                                for (int i = 0; i < tratta.size(); i++) {
                                                    System.out.println((i + 1) + " " + tratta.get(i));
                                                }
                                                try {
                                                    trattaSelezionata = Integer.parseInt(scanner.nextLine()) - 1;
                                                    if (trattaSelezionata < 0 || trattaSelezionata >= tratta.size()) {
                                                        System.out.println(
                                                                "Errore: Numero tratta non valido! Scegli un numero " +
                                                                        "tra 1 e " + tratta.size() + ".\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Errore: Inserisci un numero intero valido!\n");
                                                    trattaSelezionata = -1;
                                                }
                                            }

                                            UUID idMezzoFromDatabase4 = mezzo.get(mezzoSelezionato4)
                                                    .getId_mezzo();
                                            UUID idTrattaFromDb = tratta.get(trattaSelezionata)
                                                    .getIdTratta();

                                            Long totTempoEffettivo = percorrenzaDao.countTempoEffettivoPercorrenza(
                                                    idMezzoFromDatabase4, idTrattaFromDb);

                                            System.out.println("Il mezzo con id: " + idMezzoFromDatabase4 +
                                                    " sulla tratta " + idTrattaFromDb +
                                                    " ha un TEMPO EFFETTIVO TOTALE di: " + totTempoEffettivo + " " +
                                                    "minuti");
                                            break;
                                        default:
                                            System.out.println("Scelta non valida");
                                    }
                                } while (choice < 1 || choice > 6); //while (choice != 0); Il ciclo continua finché
                                // non digita 0, sennò ogni volta per vedere due statistiche devo ricominciare da capo
                                break;
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

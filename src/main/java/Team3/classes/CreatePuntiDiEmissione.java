package Team3.classes;

import Team3.Dao.PuntoDiEmissioneDao;
import Team3.entities.Distributore;
import Team3.entities.PuntoDiEmissione;
import Team3.entities.Rivenditore;
import Team3.entities.Utente;
import Team3.enums.StatoDistributore;

import java.time.LocalTime;
import java.util.List;

public class CreatePuntiDiEmissione {
    public CreatePuntiDiEmissione() {
    }

    public List<PuntoDiEmissione> createPuntiDiEmissione(PuntoDiEmissioneDao puntoEmissioneDao) {
        if (puntoEmissioneDao.count() == 0) {
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
        }

        List<PuntoDiEmissione> tuttiPuntiDiEmissione = puntoEmissioneDao.findAll();
        return tuttiPuntiDiEmissione;
    }
}

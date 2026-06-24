package Team3.classes;

import Team3.Dao.TitoloViaggioDAO;
import Team3.entities.*;
import Team3.enums.TipoAbbonamento;

import java.time.LocalDate;
import java.util.List;

public class CreateTitoloViaggio {
    public CreateTitoloViaggio() {
    }

    public List<TitoloViaggio> createTitoloViaggio(TitoloViaggioDAO titoloViaggioDao, List<PuntoDiEmissione> puntoDiEmissione, List<MezzoDiTrasporto> mezzo, List<Tessera> tessera) {
        if (titoloViaggioDao.count() == 0) {
            Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 5, 10), puntoDiEmissione.get(0), true, null,
                    mezzo.get(0));
            Biglietto biglietto2 = new Biglietto(LocalDate.of(2026, 1, 12), puntoDiEmissione.get(1), false, LocalDate.of(2026, 3, 1),
                    mezzo.get(1));
            Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 8), puntoDiEmissione.get(2), false, LocalDate.of(2026, 4, 13),
                    mezzo.get(2));
            Biglietto biglietto4 = new Biglietto(LocalDate.of(2026, 4, 2), puntoDiEmissione.get(3), true, null,
                    mezzo.get(3));
            Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 3, 21), puntoDiEmissione.get(4), true, null,
                    mezzo.get(4));
            Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 6, 3), puntoDiEmissione.get(5), TipoAbbonamento.SETTIMANALE,
                    tessera.get(0), LocalDate.of(2026, 6, 15)); // Questo sarà SCADUTA
            Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2026, 5, 20), puntoDiEmissione.get(6), TipoAbbonamento.MENSILE,
                    tessera.get(1), LocalDate.of(2026, 6, 3)); // Questo sarà SCADUTA
            Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2026, 6, 23), puntoDiEmissione.get(7), TipoAbbonamento
                    .SETTIMANALE,
                    tessera.get(2), LocalDate.of(2026, 7, 12)); // VALIDO non scaduta
            Abbonamento abbonamento4 = new Abbonamento(LocalDate.of(2026, 6, 20), puntoDiEmissione.get(8), TipoAbbonamento.MENSILE,
                    tessera.get(3), LocalDate.of(2026, 8, 20)); //VALIDO non scaduto
            Abbonamento abbonamento5 = new Abbonamento(LocalDate.of(2026, 3, 15), puntoDiEmissione.get(9), TipoAbbonamento.MENSILE,
                    tessera.get(4), LocalDate.of(2026, 7, 22)); // SCADUTO non valido

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
        }

        List<TitoloViaggio> tuttiTitoliViaggio = titoloViaggioDao.findAll();
        return tuttiTitoliViaggio;
    }
}

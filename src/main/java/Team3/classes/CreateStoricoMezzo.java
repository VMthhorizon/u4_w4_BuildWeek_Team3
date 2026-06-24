package Team3.classes;

import Team3.Dao.StoricoMezzoDao;
import Team3.entities.MezzoDiTrasporto;
import Team3.entities.StoricoMezzo;
import Team3.entities.Utente;
import Team3.enums.TipoManutenzione;

import java.time.LocalDate;
import java.util.List;

public class CreateStoricoMezzo {
    public CreateStoricoMezzo() {
    }

    public List<StoricoMezzo> createStoricoMezzo(StoricoMezzoDao storicoMezzoDao, List<MezzoDiTrasporto> mezzo) {
        if (storicoMezzoDao.count() == 0) {
            StoricoMezzo storico1 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 26), null, null);
            StoricoMezzo storico2 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 5, 10),
                    LocalDate.of(2026, 5, 11),
                    TipoManutenzione.CARBURANTE);
            StoricoMezzo storico3 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 1),
                    LocalDate.of(2026, 6, 2),
                    TipoManutenzione.FRENI);
            StoricoMezzo storico4 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 12),
                    LocalDate.of(2026, 6, 13),
                    TipoManutenzione.GOMME);
            StoricoMezzo storico5 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 25), null, null);
            StoricoMezzo storico6 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 26), null, null);
            StoricoMezzo storico7 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 5, 20),
                    LocalDate.of(2026, 5, 21),
                    TipoManutenzione.MOTORE);
            StoricoMezzo storico8 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 5),
                    LocalDate.of(2026, 6, 6),
                    TipoManutenzione.FRENI);
            StoricoMezzo storico9 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 25), null, null);
            StoricoMezzo storico10 = new StoricoMezzo(mezzo.get(0), LocalDate.of(2026, 6, 26), null, null);

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
        }

        List<StoricoMezzo> storici = storicoMezzoDao.findAll();
        return storici;
    }
}

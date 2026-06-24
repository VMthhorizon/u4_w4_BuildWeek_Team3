package Team3.classes;

import Team3.Dao.PercorrenzaDao;
import Team3.entities.*;

import java.time.LocalDate;
import java.util.List;

public class CreatePercorrenza {
    public CreatePercorrenza() {
    }

    public List<Percorrenza> createPercorrenza(PercorrenzaDao percorrenzaDao, List<Tratta> tratta, List<MezzoDiTrasporto> mezzo) {
        if (percorrenzaDao.count() == 0) {
            Percorrenza percorrenza1 = new Percorrenza(tratta.get(0), mezzo.get(0), 30,
                    LocalDate.of(2026, 6, 22)); // IN ANTICIPO
            Percorrenza percorrenza2 = new Percorrenza(tratta.get(1), mezzo.get(1), 20,
                    LocalDate.of(2026, 6, 23)); // IN ORARIO
            Percorrenza percorrenza3 = new Percorrenza(tratta.get(2), mezzo.get(2), 22,
                    LocalDate.of(2026, 6, 24)); // IN RITARDO
            Percorrenza percorrenza4 = new Percorrenza(tratta.get(3), mezzo.get(3), 21,
                    LocalDate.of(2026, 6, 25)); // IN ANTICIPO
            Percorrenza percorrenza5 = new Percorrenza(tratta.get(4), mezzo.get(4), 12,
                    LocalDate.of(2026, 6, 26)); // IN ORARIO
            Percorrenza percorrenza6 = new Percorrenza(tratta.get(5), mezzo.get(5), 19,
                    LocalDate.of(2026, 6, 27)); // IN RITARDO
            Percorrenza percorrenza7 = new Percorrenza(tratta.get(6), mezzo.get(6), 35,
                    LocalDate.of(2026, 6, 28)); // IN RITARDO
            Percorrenza percorrenza8 = new Percorrenza(tratta.get(7), mezzo.get(7), 45,
                    LocalDate.of(2026, 6, 29)); // IN ORARIO
            Percorrenza percorrenza9 = new Percorrenza(tratta.get(8), mezzo.get(8), 18,
                    LocalDate.of(2026, 6, 30)); // IN ANTICIPO
            Percorrenza percorrenza10 = new Percorrenza(tratta.get(9), mezzo.get(9), 25,
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
        }

        List<Percorrenza> tutteLePercorrenza = percorrenzaDao.findAll();
        return tutteLePercorrenza;
    }
}

package Team3.classes;

import Team3.Dao.MezzoDiTrasportoDao;
import Team3.entities.Autobus;
import Team3.entities.MezzoDiTrasporto;
import Team3.entities.Tram;
import Team3.entities.Utente;
import Team3.enums.StatoMezzo;

import java.util.List;

public class CreateMezzo {
    public CreateMezzo() {
    }

    public List<MezzoDiTrasporto> createMezzo(MezzoDiTrasportoDao mezzoDao) {
        if (mezzoDao.count() == 0) {
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
        }

        List<MezzoDiTrasporto> tuttiIMezzi = mezzoDao.findAll();
        return tuttiIMezzi;
    }
}

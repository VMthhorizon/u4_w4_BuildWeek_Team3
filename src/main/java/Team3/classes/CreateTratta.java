package Team3.classes;

import Team3.Dao.TrattaDao;
import Team3.entities.Tratta;
import Team3.entities.Utente;

import java.util.List;

public class CreateTratta {
    public CreateTratta() {
    }

    public List<Tratta> createTratta(TrattaDao trattaDao) {
        if (trattaDao.count() == 0) {
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
        }
        List<Tratta> tutteLeTratte = trattaDao.findAll();
        return tutteLeTratte;
    }
}

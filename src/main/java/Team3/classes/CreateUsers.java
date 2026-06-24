package Team3.classes;

import Team3.Dao.UtenteDao;
import Team3.entities.Utente;

import java.util.List;

public class CreateUsers {
    public CreateUsers() {
    }

    public List<Utente> createUtente(UtenteDao utenteDao) {
        if (utenteDao.count() == 0) {
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
        }

        List<Utente> tuttiGliUtenti = utenteDao.findAll();
        return tuttiGliUtenti;
    }
}

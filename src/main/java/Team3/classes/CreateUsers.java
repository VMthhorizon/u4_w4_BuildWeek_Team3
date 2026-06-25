package Team3.classes;

import Team3.Dao.UtenteDao;
import Team3.entities.Utente;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

public class CreateUsers {


    public CreateUsers() {
    }

    public List<Utente> createUtente(UtenteDao utenteDao, Faker faker) {
        if (utenteDao.count() == 0) {
            for (int i = 0; i < 40; i++) {
                Utente utente = new Utente(faker.name().firstName(), faker.name().lastName());
                utenteDao.save(utente);
            }
        }
        List<Utente> tuttiGliUtenti = utenteDao.findAll();
        return tuttiGliUtenti;
    }
}

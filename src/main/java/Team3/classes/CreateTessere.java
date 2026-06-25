package Team3.classes;

import Team3.Dao.TesseraDao;
import Team3.entities.Tessera;
import Team3.entities.Utente;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateTessere {
    public CreateTessere() {
    }

    public List<Tessera> createTessera(TesseraDao tesseraDao, List<Utente> utenti, Faker faker) {
        if (tesseraDao.count() == 0) {
            for (int i = 0; i < utenti.size(); i++) {
                Tessera tessera = new Tessera(LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(0, 730)), utenti.get(i));
                tesseraDao.save(tessera);
            }
        }
        List<Tessera> tutteLeTessere = tesseraDao.findAll();
        return tutteLeTessere;
    }
}

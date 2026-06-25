package Team3.classes;

import Team3.Dao.PuntoDiEmissioneDao;
import Team3.entities.Distributore;
import Team3.entities.PuntoDiEmissione;
import Team3.entities.Rivenditore;
import Team3.entities.Utente;
import Team3.enums.StatoDistributore;
import com.github.javafaker.Faker;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatePuntiDiEmissione {
    public CreatePuntiDiEmissione() {
    }

    public List<PuntoDiEmissione> createPuntiDiEmissione(PuntoDiEmissioneDao puntoEmissioneDao, Faker faker) {
        if (puntoEmissioneDao.count() == 0) {
            for (int i = 0; i < 15; i++) {
                Distributore distributore = new Distributore("Distributore " + faker.company().name(), faker.options().option(StatoDistributore.values()));
                Rivenditore rivenditore = new Rivenditore("Bar " + faker.animal().name(), faker.address().streetAddress(), LocalTime.of(ThreadLocalRandom.current().nextInt(7, 10), 0), LocalTime.of(ThreadLocalRandom.current().nextInt(19, 22), 0));
                puntoEmissioneDao.save(distributore);
                puntoEmissioneDao.save(rivenditore);
            }
        }
        List<PuntoDiEmissione> tuttiPuntiDiEmissione = puntoEmissioneDao.findAll();
        return tuttiPuntiDiEmissione;
    }
}

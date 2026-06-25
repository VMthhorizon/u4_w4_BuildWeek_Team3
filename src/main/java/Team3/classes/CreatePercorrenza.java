package Team3.classes;

import Team3.Dao.PercorrenzaDao;
import Team3.entities.*;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatePercorrenza {
    public CreatePercorrenza() {
    }

    public List<Percorrenza> createPercorrenza(PercorrenzaDao percorrenzaDao, List<Tratta> tratta, List<MezzoDiTrasporto> mezzo, Faker faker) {
        if (percorrenzaDao.count() == 0) {
            for (int i = 0; i < 20; i++) {
                Tratta trattaCasuale = tratta.get(ThreadLocalRandom.current().nextInt(tratta.size()));
                MezzoDiTrasporto mezzoDiTrasportoCasuale = mezzo.get(ThreadLocalRandom.current().nextInt(mezzo.size()));
                Percorrenza percorrenza = new Percorrenza(trattaCasuale, mezzoDiTrasportoCasuale, faker.number().numberBetween(15, 70), LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(11, 90)));
                percorrenzaDao.save(percorrenza);
            }
        }
        List<Percorrenza> tutteLePercorrenza = percorrenzaDao.findAll();
        return tutteLePercorrenza;
    }
}

package Team3.classes;

import Team3.Dao.TrattaDao;
import Team3.entities.Tratta;
import Team3.entities.Utente;
import com.github.javafaker.Faker;

import java.util.List;

public class CreateTratta {
    public CreateTratta() {
    }

    public List<Tratta> createTratta(TrattaDao trattaDao, Faker faker) {
        List<String> fermate = List.of(
                "Stazione Centrale",
                "Porto",
                "Ospedale",
                "Università",
                "Municipio",
                "Centro",
                "Aeroporto",
                "Piazza Colombo",
                "Corso Imperatrice",
                "San Martino"
        );
        if (trattaDao.count() == 0) {
            for (int i = 0; i < 20; i++) {
                Tratta tratta = new Tratta(fermate.get(faker.number().numberBetween(0, fermate.size())), fermate.get(faker.number().numberBetween(0, fermate.size())), faker.number().numberBetween(20, 60));
                trattaDao.save(tratta);
            }
        }
        List<Tratta> tutteLeTratte = trattaDao.findAll();
        return tutteLeTratte;
    }
}

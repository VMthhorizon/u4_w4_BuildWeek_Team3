package Team3.classes;

import Team3.Dao.MezzoDiTrasportoDao;
import Team3.entities.Autobus;
import Team3.entities.MezzoDiTrasporto;
import Team3.entities.Tram;
import Team3.entities.Utente;
import Team3.enums.StatoMezzo;
import com.github.javafaker.Faker;

import java.util.List;

public class CreateMezzo {
    public CreateMezzo() {
    }

    public List<MezzoDiTrasporto> createMezzo(MezzoDiTrasportoDao mezzoDao, Faker faker) {
        if (mezzoDao.count() == 0) {
            for (int i = 0; i < 15; i++) {
                Tram tram = new Tram(faker.options().option(StatoMezzo.values()), faker.number().numberBetween(80, 200));
                Autobus autobus = new Autobus(faker.options().option(StatoMezzo.values()), faker.number().numberBetween(50, 120));
                mezzoDao.save(tram);
                mezzoDao.save(autobus);
            }
        }
        List<MezzoDiTrasporto> tuttiIMezzi = mezzoDao.findAll();
        return tuttiIMezzi;
    }
}

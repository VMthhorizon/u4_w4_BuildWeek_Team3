package Team3.classes;

import Team3.Dao.StoricoMezzoDao;
import Team3.entities.MezzoDiTrasporto;
import Team3.entities.StoricoMezzo;
import Team3.entities.Utente;
import Team3.enums.StatoMezzo;
import Team3.enums.TipoManutenzione;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateStoricoMezzo {
    public CreateStoricoMezzo() {
    }

    public List<StoricoMezzo> createStoricoMezzo(StoricoMezzoDao storicoMezzoDao, List<MezzoDiTrasporto> mezzo, Faker faker) {
        if (storicoMezzoDao.count() == 0) {
            for (int i = 0; i < 20; i++) {
                MezzoDiTrasporto mezzoDiTrasportoCasuale = mezzo.get(ThreadLocalRandom.current().nextInt(mezzo.size()));
                LocalDate dataFine;

                if (ThreadLocalRandom.current().nextBoolean()) {
                    dataFine = null;
                    mezzoDiTrasportoCasuale.setStato(StatoMezzo.MANUTENZIONE);
                } else {
                    dataFine = LocalDate.now()
                            .minusDays(ThreadLocalRandom.current().nextInt(0, 10));
                    mezzoDiTrasportoCasuale.setStato(StatoMezzo.SERVIZIO);
                }
                StoricoMezzo storicoMezzo = new StoricoMezzo(mezzoDiTrasportoCasuale, LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(11, 90)), dataFine, faker.options().option(TipoManutenzione.values()));
                storicoMezzoDao.save(storicoMezzo);
            }
        }
        List<StoricoMezzo> storici = storicoMezzoDao.findAll();
        return storici;
    }
}

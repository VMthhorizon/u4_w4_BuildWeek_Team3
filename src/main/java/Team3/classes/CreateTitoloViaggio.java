package Team3.classes;

import Team3.Dao.TitoloViaggioDAO;
import Team3.entities.*;
import Team3.enums.TipoAbbonamento;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateTitoloViaggio {
    public CreateTitoloViaggio() {
    }

    public List<TitoloViaggio> createTitoloViaggio(TitoloViaggioDAO titoloViaggioDao, List<PuntoDiEmissione> puntoDiEmissione, List<MezzoDiTrasporto> mezzo, List<Tessera> tessera, Faker faker) {
        if (titoloViaggioDao.count() == 0) {
            for (int i = 0; i < 40; i++) {
                PuntoDiEmissione puntoDiEmissioneCasuale = puntoDiEmissione.get(ThreadLocalRandom.current().nextInt(puntoDiEmissione.size()));
                MezzoDiTrasporto mezzoDiTrasportoCasuale = mezzo.get(ThreadLocalRandom.current().nextInt(mezzo.size()));
                Tessera tesseraCasuale = tessera.get(ThreadLocalRandom.current().nextInt(tessera.size()));
                LocalDate dataUtilizzo;
                if (ThreadLocalRandom.current().nextBoolean()) {
                    dataUtilizzo = null;
                } else {
                    dataUtilizzo = LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(0, 365));
                }

                Biglietto biglietto = new Biglietto(LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(0, 365)), puntoDiEmissioneCasuale, ThreadLocalRandom.current().nextBoolean(), dataUtilizzo, mezzoDiTrasportoCasuale);
                Abbonamento abbonamento = new Abbonamento(LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(0, 365)), puntoDiEmissioneCasuale, TipoAbbonamento.MENSILE,
                        tesseraCasuale, LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(0, 730)));

                titoloViaggioDao.save(biglietto);
                titoloViaggioDao.save(abbonamento);
            }
        }
        List<TitoloViaggio> tuttiTitoliViaggio = titoloViaggioDao.findAll();
        return tuttiTitoliViaggio;
    }
}

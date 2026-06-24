package Team3.classes;

import Team3.Dao.TesseraDao;
import Team3.entities.Tessera;
import Team3.entities.Utente;

import java.time.LocalDate;
import java.util.List;

public class CreateTessere {
    public CreateTessere() {
    }

    public List<Tessera> createTessera(TesseraDao tesseraDao, List<Utente> utenti) {
        if (tesseraDao.count() == 0) {
            Tessera tessera1 = new Tessera(LocalDate.of(2026, 4, 20), utenti.get(0));
            Tessera tessera2 = new Tessera(LocalDate.of(2024, 6, 18), utenti.get(1));
            Tessera tessera3 = new Tessera(LocalDate.of(2025, 5, 3), utenti.get(2));
            Tessera tessera4 = new Tessera(LocalDate.of(2025, 8, 19), utenti.get(3));
            Tessera tessera5 = new Tessera(LocalDate.of(2025, 11, 12), utenti.get(4));
            Tessera tessera6 = new Tessera(LocalDate.of(2026, 1, 5), utenti.get(5));
            Tessera tessera7 = new Tessera(LocalDate.of(2026, 3, 30), utenti.get(6));
            Tessera tessera8 = new Tessera(LocalDate.of(2026, 5, 14), utenti.get(7));
            Tessera tessera9 = new Tessera(LocalDate.of(2026, 6, 22), utenti.get(8));
            Tessera tessera10 = new Tessera(LocalDate.of(2025, 2, 15), utenti.get(9));

            Tessera t1 = tesseraDao.save(tessera1);
            Tessera t2 = tesseraDao.save(tessera2);
            Tessera t3 = tesseraDao.save(tessera3);
            Tessera t4 = tesseraDao.save(tessera4);
            Tessera t5 = tesseraDao.save(tessera5);
            Tessera t6 = tesseraDao.save(tessera6);
            Tessera t7 = tesseraDao.save(tessera7);
            Tessera t8 = tesseraDao.save(tessera8);
            Tessera t9 = tesseraDao.save(tessera9);
            Tessera t10 = tesseraDao.save(tessera10);
        }

        List<Tessera> tutteLeTessere = tesseraDao.findAll();
        return tutteLeTessere;
    }
}

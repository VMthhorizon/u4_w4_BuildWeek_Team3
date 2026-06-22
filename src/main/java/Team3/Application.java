package Team3;

import Team3.Dao.MezzoDiTrasportoDao;
import Team3.entities.Autobus;
import Team3.entities.Tram;
import Team3.enums.StatoMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4buildweekpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        MezzoDiTrasportoDao mezzoDao = new MezzoDiTrasportoDao(em);

        Tram Tram1 = new Tram(StatoMezzo.SERVIZIO, 80);
        Autobus Bus1 = new Autobus(StatoMezzo.MANUTENZIONE, 200);

        mezzoDao.saveMezzo(Tram1);
        mezzoDao.saveMezzo(Bus1);
    }
}

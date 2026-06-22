package Team3.entities;

import Team3.enums.StatoMezzo;
import jakarta.persistence.Entity;

@Entity
public class Tram extends MezzoDiTrasporto {

    protected Tram() {
    }

    public Tram(StatoMezzo stato, int capienza) {
        super(stato, capienza);
    }
}

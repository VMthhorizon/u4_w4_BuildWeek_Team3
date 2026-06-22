package Team3.entities;

import Team3.enums.StatoMezzo;
import jakarta.persistence.Entity;

@Entity
public class Autobus extends MezzoDiTrasporto {
    protected Autobus() {
    }

    public Autobus(StatoMezzo stato, int capienza) {
        super(stato, capienza);
    }
}

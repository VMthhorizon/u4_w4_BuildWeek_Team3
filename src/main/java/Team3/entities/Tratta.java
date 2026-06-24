package Team3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue
    private UUID idTratta;
    private String zonaPartenza;
    private String zonaCapolinea;
    private int tempoPrevisto;

    protected Tratta() {
    }

    public Tratta(String zonaPartenza, String zonaCapolinea, int tempoPrevisto) {
        this.zonaPartenza = zonaPartenza;
        this.zonaCapolinea = zonaCapolinea;
        this.tempoPrevisto = tempoPrevisto;
    }

    public UUID getIdTratta() {
        return idTratta;
    }

    public int getTempoPrevisto() {
        return tempoPrevisto;
    }

    public String getZonaCapolinea() {
        return zonaCapolinea;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "idTratta=" + idTratta +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", zonaCapolinea='" + zonaCapolinea + '\'' +
                ", tempoPrevisto=" + tempoPrevisto +
                '}';
    }
}

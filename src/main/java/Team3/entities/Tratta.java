package Team3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Tratte")
public class Tratta {
    @Id
    @GeneratedValue
    private UUID id_tratta;
    private String zona_partenza;
    private String zona_capolinea;
    private int tempo_previsto;

    protected Tratta() {
    }

    public Tratta(String zona_partenza, String zona_capolinea, int tempo_previsto) {
        this.zona_partenza = zona_partenza;
        this.zona_capolinea = zona_capolinea;
        this.tempo_previsto = tempo_previsto;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id_tratta=" + id_tratta +
                ", zona_partenza='" + zona_partenza + '\'' +
                ", zona_capolinea='" + zona_capolinea + '\'' +
                ", tempo_previsto=" + tempo_previsto +
                '}';
    }
}

package Team3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Percorrenze")
public class Percorrenza {
    @Id
    @GeneratedValue
    private UUID id_percorrenza;
    @ManyToOne
    @JoinColumn(name = "id_tratta")
    private Tratta id_tratta;
    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto id_mezzo;
    private int tempo_effettivo;
    private LocalDate data_percorrenza;

    protected Percorrenza() {
    }

    public Percorrenza(Tratta id_tratta, MezzoDiTrasporto id_mezzo, int tempo_effettivo, LocalDate data_percorrenza) {
        this.id_tratta = id_tratta;
        this.id_mezzo = id_mezzo;
        this.tempo_effettivo = tempo_effettivo;
        this.data_percorrenza = data_percorrenza;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "id_percorrenza=" + id_percorrenza +
                ", id_tratta=" + id_tratta +
                ", id_mezzo=" + id_mezzo +
                ", tempo_effettivo=" + tempo_effettivo +
                ", data_percorrenza=" + data_percorrenza +
                '}';
    }
}

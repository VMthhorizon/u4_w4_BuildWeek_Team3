package Team3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "percorrenze")
public class Percorrenza {
    @Id
    @GeneratedValue
    private UUID idPercorrenza;
    @ManyToOne
    @JoinColumn(name = "id_tratta")
    private Tratta tratta;
    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto mezzoDiTrasporto;
    private int tempoEffettivo;
    private LocalDate dataPercorrenza;

    protected Percorrenza() {
    }

    public Percorrenza(Tratta tratta, MezzoDiTrasporto mezzoDiTrasporto, int tempoEffettivo,
                       LocalDate dataPercorrenza) {
        this.tratta = tratta;
        this.mezzoDiTrasporto = mezzoDiTrasporto;
        this.tempoEffettivo = tempoEffettivo;
        this.dataPercorrenza = dataPercorrenza;
    }


    public UUID getIdPercorrenza() {
        return idPercorrenza;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "idPercorrenza=" + idPercorrenza +
                ", tratta=" + tratta +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                ", tempoEffettivo=" + tempoEffettivo +
                ", dataPercorrenza=" + dataPercorrenza +
                '}';
    }
}

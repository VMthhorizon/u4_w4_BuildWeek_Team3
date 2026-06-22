package Team3.entities;

import Team3.enums.StatoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "storico_mezzi")
public class StoricoMezzo {
    @Id
    @GeneratedValue
    private UUID idStorico;
    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto mezzoDiTrasporto;
    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;
    @Column(name = "data_inizio", nullable = false)
    private LocalDate dataInizio;
    @Column(name = "data_fine", nullable = false)
    private LocalDate dataFine;

    protected StoricoMezzo() {
    }

    public StoricoMezzo(MezzoDiTrasporto mezzoDiTrasporto, LocalDate dataInizio, LocalDate dataFine) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
        this.stato = mezzoDiTrasporto.getStato();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "StoricoMezzo{" +
                "idStorico=" + idStorico +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                ", stato=" + stato +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}

package Team3.entities;

import Team3.enums.StatoMezzo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Storico_mezzi")
public class StoricoMezzo {
    @Id
    @GeneratedValue
    private UUID id_storico;
    @ManyToOne
    @JoinColumn(name = "id_mezzo")
    private MezzoDiTrasporto id_mezzo;
    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;
    private LocalDate data_inizio;
    private LocalDate data_fine;

    protected StoricoMezzo() {
    }

    public StoricoMezzo(MezzoDiTrasporto id_mezzo, StatoMezzo stato, LocalDate data_inizio, LocalDate data_fine) {
        this.id_mezzo = id_mezzo;
        this.stato = stato;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
    }

    @Override
    public String toString() {
        return "StoricoMezzo{" +
                "id_storico=" + id_storico +
                ", id_mezzo=" + id_mezzo +
                ", stato=" + stato +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                '}';
    }
}

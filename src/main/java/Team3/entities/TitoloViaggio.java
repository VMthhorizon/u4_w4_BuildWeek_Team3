package Team3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "titoli_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class TitoloViaggio {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "data_emissione", nullable = false)
    private LocalDate dataEmissione;
    @ManyToOne
    @JoinColumn(name = "emissione_id", nullable = false)
    private PuntoDiEmissione puntoDiEmissione;

    protected TitoloViaggio() {
    }

    public TitoloViaggio(LocalDate dataEmissione, PuntoDiEmissione puntoDiEmissione) {
        this.dataEmissione = dataEmissione;
        this.puntoDiEmissione = puntoDiEmissione;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public PuntoDiEmissione getPuntoDiEmissione() {
        return puntoDiEmissione;
    }

    @Override
    public String toString() {
        return "TitoloViaggio{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", puntoDiEmissione=" + puntoDiEmissione +
                '}';
    }
}

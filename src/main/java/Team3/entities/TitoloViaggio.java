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
    @Column(name = "emissione_id", nullable = false)
    private UUID emissioneId; // ------------------ DA SOSTITUIRE CON LA CLASSE --------------------

    protected TitoloViaggio() {
    }

    public TitoloViaggio(LocalDate dataEmissione, UUID emissioneId) {
        this.dataEmissione = dataEmissione;
        this.emissioneId = emissioneId;
    }
}

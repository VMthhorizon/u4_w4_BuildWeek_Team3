package Team3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "data_emissione", nullable = false)
    private LocalDate dataEmissione;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate dataScadenza;

    @OneToOne
    @JoinColumn(name = "id_utente", unique = true, nullable = false)
    private Utente utente;

    // COSTRUTTORE VUOTO
    protected Tessera() {

    }

    // COSTRUTTORE
    public Tessera(LocalDate dataEmissione, Utente utente) {
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
        this.utente = utente;
    }

    // GETTER
    public UUID getId() {
        return id;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                ", id utente=" + utente.getId() +
                '}';
    }
}

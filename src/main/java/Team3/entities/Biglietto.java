package Team3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "biglietti")
@DiscriminatorValue("tipo")
public class Biglietto extends TitoloViaggio {
    @Column(name = "is_valido", nullable = false)
    private boolean isValido;
    @Column(name = "data_di_utilizzo", nullable = false)
    private LocalDate dataDiUtilizzo;
    @Column(name = "id_mezzo", nullable = false)
    private UUID idMezzo; // ------------- AGGIORNARE CON CLASSE ---------------------

    protected Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, UUID emissioneId, boolean isValido, LocalDate dataDiUtilizzo, UUID idMezzo) {
        super(dataEmissione, emissioneId);
        this.isValido = isValido;
        this.dataDiUtilizzo = dataDiUtilizzo;
        this.idMezzo = idMezzo;
    }

    public boolean GetIsValido() {
        return isValido;
    }

    public LocalDate getDataDiUtilizzo() {
        return dataDiUtilizzo;
    }

    public UUID getIdMezzo() {
        return idMezzo;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "isValido=" + isValido +
                ", dataDiUtilizzo=" + dataDiUtilizzo +
                ", idMezzo=" + idMezzo +
                '}';
    }
}

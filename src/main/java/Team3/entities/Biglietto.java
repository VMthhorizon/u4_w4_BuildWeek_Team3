package Team3.entities;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "id_mezzo", nullable = false)
    private MezzoDiTrasporto mezzoDiTrasporto;

    protected Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, PuntoDiEmissione puntoDiEmissione, boolean isValido,
                     LocalDate dataDiUtilizzo,
                     MezzoDiTrasporto mezzoDiTrasporto) {
        super(dataEmissione, puntoDiEmissione);
        this.isValido = isValido;
        this.dataDiUtilizzo = dataDiUtilizzo;
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    public boolean GetIsValido() {
        return isValido;
    }

    public LocalDate getDataDiUtilizzo() {
        return dataDiUtilizzo;
    }

    @Override
    public PuntoDiEmissione getPuntoDiEmissione() {
        return super.getPuntoDiEmissione();
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "isValido=" + isValido +
                ", dataDiUtilizzo=" + dataDiUtilizzo +
                ", mezzoDiTrasporto=" + mezzoDiTrasporto +
                "} " + super.toString();
    }
}

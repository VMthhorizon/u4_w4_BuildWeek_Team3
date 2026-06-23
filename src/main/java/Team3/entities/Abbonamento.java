package Team3.entities;

import Team3.enums.TipoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
@DiscriminatorValue("abbonamento")
public class Abbonamento extends TitoloViaggio {
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipo;
    @ManyToOne
    @JoinColumn(name = "id_tessera", nullable = false)
    private Tessera tessera;
    @Column(name = "data_inizio_abbonamento")
    private LocalDate dataInizioAbbonamento;

    protected Abbonamento() {
    }

    public Abbonamento(LocalDate dataEmissione, PuntoDiEmissione puntoDiEmissione, TipoAbbonamento tipo,
                       Tessera tessera, LocalDate dataInizioAbbonamento) {
        super(dataEmissione, puntoDiEmissione);
        this.tipo = tipo;
        this.tessera = tessera;
        this.dataInizioAbbonamento = dataInizioAbbonamento;
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public Tessera getTessera() {
        return tessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tipo=" + tipo +
                ", tessera=" + tessera +
                "} " + super.toString();
    }
}

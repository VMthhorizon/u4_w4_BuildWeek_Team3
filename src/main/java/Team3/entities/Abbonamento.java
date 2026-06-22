package Team3.entities;

import Team3.enums.TipoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
@DiscriminatorValue("tipo")
public class Abbonamento extends TitoloViaggio {
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipo;
    @Column(name = "id_tessera", nullable = false)
    private UUID idTessera; // ------------ DA AGGIORNARE CON LA CLASSE -----------------

    protected Abbonamento() {
    }

    public Abbonamento(LocalDate dataEmissione, UUID emissioneId, TipoAbbonamento tipo, UUID idTessera) {
        super(dataEmissione, emissioneId);
        this.tipo = tipo;
        this.idTessera = idTessera;
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public UUID getIdTessera() {
        return idTessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tipo=" + tipo +
                ", idTessera=" + idTessera +
                '}';
    }
}

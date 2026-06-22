package Team3.entities;

import Team3.enums.StatoDistributore;
import jakarta.persistence.*;


@Entity
@Table(name = "distributori")
@DiscriminatorValue("distributori")
public class Distributore extends PuntoDiEmissione {

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoDistributore stato;

    // Costruttore vuoto

    protected Distributore() {
    }

    // Costruttore con parametri

    public Distributore(String nome, StatoDistributore stato) {
        super(nome);
        this.stato = stato;
    }

    // Getter e Setter

    public StatoDistributore getStato() {
        return stato;
    }

    public void setStato(StatoDistributore stato) {
        this.stato = stato;
    }
}
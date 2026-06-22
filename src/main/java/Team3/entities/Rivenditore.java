package Team3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rivenditori")
@DiscriminatorValue("RIVENDITORE")
public class Rivenditore extends PuntoDiEmissione {

    @Column(name = "isOpen")
    private Boolean isOpen;

    // Costruttore vuoto

    public Rivenditore() {
    }

    // Costruttore con parametri

    public Rivenditore(String nome, Boolean isOpen) {
        super(nome);
        this.isOpen = isOpen;
    }

    // Getter e Setter

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
}
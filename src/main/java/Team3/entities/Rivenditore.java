package Team3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rivenditori")
@DiscriminatorValue("rivenditori")
public class Rivenditore extends PuntoDiEmissione {

    @Column(name = "descrizione")
    private String descrizione;

    // Costruttore vuoto

    public Rivenditore() {
    }

    // Costruttore con parametri

    public Rivenditore(String nome, String descrizione) {
        super(nome);
        this.descrizione = descrizione;
    }

    // Getter e Setter


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
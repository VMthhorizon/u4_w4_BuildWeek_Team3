package Team3.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "rivenditori")
@DiscriminatorValue("rivenditori")
public class Rivenditore extends PuntoDiEmissione {

    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "orario_apertura")
    private LocalTime apertura;
    @Column(name = "orario_chiusura")
    private LocalTime chiusura;

    // Costruttore vuoto

    public Rivenditore() {
    }

    // Costruttore con parametri

    public Rivenditore(String nome, String indirizzo, LocalTime apertura, LocalTime chiusura) {
        super(nome);
        this.indirizzo = indirizzo;
        this.apertura = apertura;
        this.chiusura = chiusura;
    }

    // Getter e Setter


    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
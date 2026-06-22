package Team3.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String cognome;

    @OneToOne(mappedBy = "utente")
    private Tessera tessera;

    // COSTRUTTORE VUOTO
    protected Utente() {

    }

    // COSTRUTTORE
    public Utente(String nome, String cognome, Tessera tessera) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // GETTER
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tessera=" + tessera.getId() +
                '}';
    }
}

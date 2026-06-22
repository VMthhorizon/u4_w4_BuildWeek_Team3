package Team3.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "punti_di_emissione")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_punto")
public abstract class PuntoDiEmissione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    // Costruttore vuoto

    protected PuntoDiEmissione() {
    }

    // Costruttore con parametri

    public PuntoDiEmissione(String nome) {
        this.nome = nome;
    }

    // Getter e Setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PuntoDiEmissione{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
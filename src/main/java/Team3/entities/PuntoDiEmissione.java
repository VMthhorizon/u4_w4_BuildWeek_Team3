package Team3.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "punti_di_emissione")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_punto")
public abstract class PuntoDiEmissione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    // Costruttore vuoto

    public PuntoDiEmissione() {
    }

    // Costruttore con parametri

    public PuntoDiEmissione(String nome) {
        this.nome = nome;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
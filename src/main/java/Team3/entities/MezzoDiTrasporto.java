package Team3.entities;

import Team3.enums.StatoMezzo;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MezziDiTrasporto")
public abstract class MezzoDiTrasporto {
    @Id
    @GeneratedValue
    private UUID id_mezzo;
    @JoinColumn(name = "stato_mezzo")
    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;
    private int capienza;

    protected MezzoDiTrasporto() {
    }

    public MezzoDiTrasporto(StatoMezzo stato, int capienza) {
        this.stato = stato;
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id_mezzo=" + id_mezzo +
                ", stato=" + stato +
                ", capienza=" + capienza +
                '}';
    }
}

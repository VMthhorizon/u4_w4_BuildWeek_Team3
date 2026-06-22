package Team3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Storico_mezzi")
public class StoricoMezzo {
    @Id
    @GeneratedValue
    private UUID id_storico;
}

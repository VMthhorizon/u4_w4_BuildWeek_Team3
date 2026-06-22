package Team3.exceptions;

import Team3.entities.MezzoDiTrasporto;

public class MezzoNotSaved extends RuntimeException {
    public MezzoNotSaved(MezzoDiTrasporto mezzo) {
        super("Il mezzo non é stato salvato correttamente");
    }
}

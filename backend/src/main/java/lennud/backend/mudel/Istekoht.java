package lennud.backend.mudel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Istekoht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean saadaval;

    public Istekoht() {
        this.saadaval = true;
    }

    public boolean kasSaadaval() {
        return saadaval;
    }

    public void märgiVõetuks() {
        saadaval = false;
    }
}

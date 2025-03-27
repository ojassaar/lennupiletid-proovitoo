package lennud.backend.mudel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Istekoht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean saadaval;

    @ManyToOne
    @JoinColumn(name = "lend_id")
    Lend lend;

    public Istekoht() {}

    public Istekoht(Lend lend) {
        this.lend = lend;
        this.saadaval = true;
    }

    public long getId() {
        return id;
    }

    public boolean kasSaadaval() {
        return saadaval;
    }

    public void märgiVõetuks() {
        saadaval = false;
    }
}

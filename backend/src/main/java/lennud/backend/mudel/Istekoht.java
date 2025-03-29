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
    private int rida;
    private int koht;

    @ManyToOne
    @JoinColumn(name = "lend", nullable = false)
    Lend lend;

    public Istekoht() {}

    public Istekoht(Lend lend, int rida, int koht) {
        this.lend = lend;
        this.rida = rida;
        this.koht = koht;
        this.saadaval = true;
    }

    public long getId() {
        return id;
    }

    public boolean isSaadaval() {
        return saadaval;
    }

    public void märgiVõetuks() {
        saadaval = false;
    }

    public int getRida() {
        return rida;
    }

    public int getKoht() {
        return koht;
    }
}

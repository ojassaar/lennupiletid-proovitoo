package lennud.backend.mudel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Lennuk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nimi;
    protected int istmeridu;
    protected int vasakulIstmeid;
    protected int paremalIstmeid;
    protected int väljapääsuRida;

    public Lennuk() {}

    protected Lennuk(String nimi, int istmeridu, int vasakulIstmeid, int paremalIstmeid, int väljapääsuRida) {
        this.nimi = nimi;
        this.istmeridu = istmeridu;
        this.vasakulIstmeid = vasakulIstmeid;
        this.paremalIstmeid = paremalIstmeid;
        this.väljapääsuRida = väljapääsuRida;
    }

    public long getId() {
        return id;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIstmeridu() {
        return istmeridu;
    }

    public int getVasakulIstmeid() {
        return vasakulIstmeid;
    }

    public int getParemalIstmeid() {
        return paremalIstmeid;
    }

    public int getVäljapääsuRida() {
        return väljapääsuRida;
    }

}
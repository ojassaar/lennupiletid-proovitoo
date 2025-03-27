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
    protected int väljaPääsuRida;

    public Lennuk() {}

    protected Lennuk(String nimi, int istmeridu, int vasakulIstmeid, int paremalIstmeid, int väljaPääsuRida) {
        this.nimi = nimi;
        this.istmeridu = istmeridu;
        this.vasakulIstmeid = vasakulIstmeid;
        this.paremalIstmeid = paremalIstmeid;
        this.väljaPääsuRida = väljaPääsuRida;
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
        return väljaPääsuRida;
    }

}
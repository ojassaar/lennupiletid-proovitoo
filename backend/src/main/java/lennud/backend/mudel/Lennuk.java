package lennud.backend.mudel;

public abstract class Lennuk {

    protected final String nimi;
    protected final int istmeridu;
    protected final int vasakulIstmeid;
    protected final int paremalIstmeid;
    protected final int väljaPääsuRida;

    protected Lennuk(String nimi, int istmeridu, int vasakulIstmeid, int paremalIstmeid, int väljaPääsuRida) {
        this.nimi = nimi;
        this.istmeridu = istmeridu;
        this.vasakulIstmeid = vasakulIstmeid;
        this.paremalIstmeid = paremalIstmeid;
        this.väljaPääsuRida = väljaPääsuRida;
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
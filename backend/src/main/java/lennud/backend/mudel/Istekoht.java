package lennud.backend.mudel;

public class Istekoht {

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

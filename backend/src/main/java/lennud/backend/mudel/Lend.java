package lennud.backend.mudel;

import java.time.LocalDateTime;

public class Lend {

    private final Lennujaam algpunkt;
    private final Lennujaam sihtpunkt;
    private final LocalDateTime väljumisaeg;
    private final LocalDateTime saabumisaeg;
    private final Lennuk lennuk;
    private final double piletihind;
    private final Istekoht[][] istekohad;

    public Lend(Lennujaam algpunkt, Lennujaam sihtpunkt, LocalDateTime väljumisaeg, LocalDateTime saabumisaeg, Lennuk lennuk, double piletihind) {
        this.algpunkt = algpunkt;
        this.sihtpunkt = sihtpunkt;
        this.väljumisaeg = väljumisaeg;
        this.saabumisaeg = saabumisaeg;
        this.lennuk = lennuk;
        this.piletihind = piletihind;

        int ridu = lennuk.getIstmeridu();
        int kohtiReas = lennuk.getVasakulIstmeid() + lennuk.getParemalIstmeid();
        this.istekohad = new Istekoht[ridu][];
        for (int i = 0; i < ridu; i++) {
            Istekoht[] rida = new Istekoht[kohtiReas];
            for (int j = 0; j < kohtiReas; j++) {
                rida[j] = new Istekoht();
            }
            istekohad[i] = rida;
        }
    }

    public Lennujaam getAlgpunkt() {
        return algpunkt;
    }

    public Lennujaam getSihtpunkt() {
        return sihtpunkt;
    }

    public LocalDateTime getVäljumisaeg() {
        return väljumisaeg;
    }

    public LocalDateTime getSaabumisaeg() {
        return saabumisaeg;
    }

    public Lennuk getLennuk() {
        return lennuk;
    }

    public double getPiletihind() {
        return piletihind;
    }
}

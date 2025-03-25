package lennud.backend.dto;

import java.time.LocalDate;

import lennud.backend.mudel.Lennujaam;

public class Lennufilter {
    private LocalDate aeg;
    private Lennujaam algpunkt;
    private Lennujaam sihtpunkt;

    public LocalDate getAeg() {
        return aeg;
    }

    public void setAeg(LocalDate aeg) {
        this.aeg = aeg;
    }

    public Lennujaam getAlgpunkt() {
        return algpunkt;
    }

    public void setAlgpunkt(Lennujaam algpunkt) {
        this.algpunkt = algpunkt;
    }

    public Lennujaam getSihtpunkt() {
        return sihtpunkt;
    }

    public void setSihtpunkt(Lennujaam sihtpunkt) {
        this.sihtpunkt = sihtpunkt;
    }
}

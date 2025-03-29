package lennud.backend.dto;

import java.time.LocalDate;

public class Lennufilter {
    private LocalDate aeg;
    private long algpunkt;
    private long sihtpunkt;
    private long id;

    public LocalDate getAeg() {
        return aeg;
    }

    public void setAeg(LocalDate aeg) {
        this.aeg = aeg;
    }

    public long getAlgpunkt() {
        return algpunkt;
    }

    public void setAlgpunkt(long algpunkt) {
        this.algpunkt = algpunkt;
    }

    public long getSihtpunkt() {
        return sihtpunkt;
    }

    public void setSihtpunkt(long sihtpunkt) {
        this.sihtpunkt = sihtpunkt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package lennud.backend.mudel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "algpunkt_id", nullable = false)
    private Lennujaam algpunkt;
    
    @ManyToOne
    @JoinColumn(name = "sihtpunkt_id", nullable = false)
    private Lennujaam sihtpunkt;

    private LocalDateTime väljumisaeg;
    private LocalDateTime saabumisaeg;
    
    @ManyToOne
    @JoinColumn(name = "lennuk_id", nullable = false)
    private Lennuk lennuk;
    private double piletihind;
    
    @OneToMany(mappedBy = "lend")
    public List<Istekoht> istekohad;

    public Lend() {}

    public Lend(Lennujaam algpunkt, Lennujaam sihtpunkt, LocalDateTime väljumisaeg, LocalDateTime saabumisaeg, Lennuk lennuk, double piletihind) {
        this.algpunkt = algpunkt;
        this.sihtpunkt = sihtpunkt;
        this.väljumisaeg = väljumisaeg;
        this.saabumisaeg = saabumisaeg;
        this.lennuk = lennuk;
        this.piletihind = piletihind;

        this.istekohad = new ArrayList<>();
    }

    public long getId() {
        return id;
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

    public List<Istekoht> getIstekohad() {
        return istekohad;
    }

    public void setIstekohad(List<Istekoht> istekohad) {
        this.istekohad = istekohad;
    }
}

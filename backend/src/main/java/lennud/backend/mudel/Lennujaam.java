package lennud.backend.mudel;

import jakarta.persistence.*;;

@Entity
public class Lennujaam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nimi;
    private String kood;

    public Lennujaam() {}

    public Lennujaam(String nimi, String kood) {
        this.nimi = nimi;
        this.kood = kood;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKood() {
        return kood;
    }

}

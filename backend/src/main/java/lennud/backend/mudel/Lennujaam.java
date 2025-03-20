package lennud.backend.mudel;

public class Lennujaam {

    private final String nimi;
    private final String kood;

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

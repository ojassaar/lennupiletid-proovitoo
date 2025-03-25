package lennud.backend.mudel;

import jakarta.persistence.Entity;

@Entity
public class CRJ900 extends Lennuk {

    // Bombardier CRJ900
    public CRJ900(String nimi) {
        super(nimi, 25, 2, 2, 18);
    }
    
}
package lennud.backend.mudel;

import jakarta.persistence.Entity;

@Entity
public class E190 extends Lennuk {

    public E190() {}

    // Embraer E190
    public E190(String nimi) {
        super(nimi, 30, 2, 2, 12);
    }
    
}
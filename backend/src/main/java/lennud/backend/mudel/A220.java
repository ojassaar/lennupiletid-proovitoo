package lennud.backend.mudel;

import jakarta.persistence.Entity;

@Entity
public class A220 extends Lennuk {

    // Airbus A220
    public A220(String nimi) {
        super(nimi, 30, 2, 3, 13);
    }
    
}
